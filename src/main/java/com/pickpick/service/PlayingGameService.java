package com.pickpick.service;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.playingGame.*;
import com.pickpick.entity.PlayingGame;
import com.pickpick.entity.PlayingGamePlayers;
import com.pickpick.repository.LoserPlayerMapper;
import com.pickpick.repository.PlayingGameMapper;
import com.pickpick.repository.PlayingGamePlayersMapper;
import com.pickpick.repository.WinnerPlayerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class
PlayingGameService {

    private final PlayingGameMapper playingGameMapper;
    private final PlayingGamePlayersMapper playingGamePlayersMapper;
    private final PlayerService playerService;
    private final WinnerPlayerMapper winnerPlayerMapper;
    private final LoserPlayerMapper loserPlayerMapper;

    public int saveGameAndPlayers(PlayingGameSaveRequestDTO dto) {

        // 우선 플레이중인 게임을 만든 뒤 id를 리턴받는다.
        PlayingGame newPlayingGame = PlayingGame.builder()
                .gameId(dto.getGameId())
                .totalRound(dto.getTotalRound())
                .accountId(dto.getAccountId())
                .currentRound(dto.getCurrentRound())
                .build();

        playingGameMapper.save(newPlayingGame);

        int playingGameId = newPlayingGame.getPlayingGameId();

        log.info("playingGameId : {}", playingGameId);

        // 그후 플레이어 목록과 위의 id를 이용하여 플레이중인 게임 플레이어들을 db에 저장한다.
        dto.getPlayerIdList()
                .forEach(pId -> {
                    PlayingGamePlayers newPlayingGamePlayer = PlayingGamePlayers.builder()
                            .playerId(pId)
                            .playingGameId(playingGameId)
                            .build();
                    playingGamePlayersMapper.save(newPlayingGamePlayer);
                });

        return playingGameId;
    }

    public void updateEndOfMatch(MatchUpdateRequestDTO dto) {

        for (Integer loser : dto.getLosers()) {
            // 진사람 삭제
            playingGamePlayersMapper.delete(PlayingGamePlayers.builder()
                    .playingGameId(dto.getPlayingGameId())
                    .playerId(loser)
                    .build());
        }

    }

    public void updateEndOfRound(int playingGameId) {

        // 현재 라운드를 2로 나눈 후 업데이트
        playingGameMapper.update(PlayingGame.builder()
                .playingGameId(playingGameId)
                .currentRound(playingGameMapper.findOne(playingGameId)
                        .getCurrentRound() >> 1)
                .build());

    }

    public void deletePlayingGame(int playingGameId) {

        playingGameMapper.delete(playingGameId);

    }

    public PlayingGameAndPlayersResponseDTO findOne(int playingGameId) {

        PlayingGame game = playingGameMapper.findOne(playingGameId);
        List<PlayingGamePlayers> players = playingGamePlayersMapper.findAllByGameId(playingGameId);
//        log.info("players : {}", players);

        return PlayingGameAndPlayersResponseDTO.builder()
                .totalRound(game.getTotalRound())
                .currentRound(game.getCurrentRound())
                .randomTwoPlayers(players.stream()
                        .sorted(Comparator.comparingInt(a -> (int) (Math.random() * players.size())))
                        .limit(2)
                        .map(p -> playerService.findOne(p.getPlayerId()))
                        .collect(Collectors.toList()))
                .build();

    }

    public List<PlayingGameListResponseDTO> findAll(int accountId, Page page) {

        return playingGameMapper.findByAccountId(accountId, page).stream()
                .map(PlayingGameListResponseDTO::new)
                .collect(Collectors.toList());

    }

    public PlayingGameAndPlayersResponseDTO match(MatchPlayingRequestDTO dto) {
        int playingGameId = dto.getPlayingGameId();
        int winnerId = dto.getWinnerId();
        int loserId = dto.getLoserId();

        // 카운트 증가 처리
        playerService.playerMatchWin(winnerId);
        playerService.playerMatchLose(loserId);

        // playingGamePlayers 테이블에서 제거
        playingGamePlayersMapper.delete(PlayingGamePlayers.builder()
                .playingGameId(playingGameId)
                .playerId(winnerId)
                .build());
        playingGamePlayersMapper.delete(PlayingGamePlayers.builder()
                .playingGameId(playingGameId)
                .playerId(loserId)
                .build());

        // 각각 winner loser 테이블에 추가
        winnerPlayerMapper.save(winnerId, playingGameId);
        loserPlayerMapper.save(loserId, playingGameId);

        // 라운드가 끝났는지 중간인지 게임이 끝났는지 확인하는 로직
        PlayingGame game = playingGameMapper.findOne(playingGameId);
        int totalRound = game.getTotalRound();
        int currentRound = game.getCurrentRound();
        log.info("current round : {} ", currentRound);

        if (playingGamePlayersMapper.count(playingGameId) == 0) { // 라운드 끝

            // currentRound를 2로 나눠주기
            game.setCurrentRound(game.getCurrentRound() >> 1);

            // 게임 끝
            if (game.getCurrentRound() == 1) {
                log.info("total round : {}", totalRound);
                int gameId = getGameId(playingGameId);

                playingGameMapper.delete(playingGameId);
                playerService.playerWin(winnerId);

                return PlayingGameAndPlayersResponseDTO.builder()
                        .totalRound(totalRound)
                        .gameId(gameId)
                        .build();
            }

            // 위너 플레이어 테이블의 현재 라운드 수에 맞는 선수들만 플레잉 게임 플레이어 테이블로 이동
            winnerPlayerMapper.findN(playingGameId, game.getCurrentRound()).forEach(p -> playingGamePlayersMapper.save(PlayingGamePlayers.builder()
                    .playingGameId(playingGameId)
                    .playerId(p)
                    .build()));

            // 업데이트
            playingGameMapper.update(game);
        }
        return findOne(playingGameId);
    }

    public PlayingGameAndPlayersResponseDTO reset(int playingGameId) {

        // 플레잉 게임 플레이어 테이블의 플레이어 수가 현재 카운트 수와 같으면 라운드 첫번째 매치임
        if (playingGamePlayersMapper.count(playingGameId) == playingGameMapper.findOne(playingGameId).getCurrentRound()) {

            log.info("라운드 처음에 리셋버튼 누름!");

            // 위너와 루저 테이블에서 가장 최신에 추가된 것 하나씩을 가져옴
            int winner = 0;
            int loser = 0;
            try {

                // BindingException 이 발생했다는 말은 게임의 최초임을 의미
                winner = winnerPlayerMapper.findLatest(playingGameId);
                loser = loserPlayerMapper.findLatest(playingGameId);

            } catch (BindingException e) {

                log.info("게임 시작 전으로는 되돌아갈 수 없습니다");
                return null;

            }

            // 플레잉 게임 플레이어 테이블을 전부 비워줌
            playingGamePlayersMapper.deleteAll(playingGameId);

            // 가져온 값들을 제거함
            winnerPlayerMapper.delete(winner, playingGameId);
            loserPlayerMapper.delete(loser, playingGameId);

            // 그 둘을 플레잉 게임 플레이어 테이블에 추가해줌
            playingGamePlayersMapper.save(PlayingGamePlayers.builder()
                    .playingGameId(playingGameId)
                    .playerId(winner)
                    .build());
            playingGamePlayersMapper.save(PlayingGamePlayers.builder()
                    .playingGameId(playingGameId)
                    .playerId(loser)
                    .build());

            // 현재 라운드를 다시 올려줌
            PlayingGame playingGame = playingGameMapper.findOne(playingGameId);
            playingGame.setCurrentRound(playingGame.getCurrentRound() << 1);
            playingGameMapper.update(playingGame);

            return findOne(playingGameId);
        }

        // 위너 테이블과 루저 테이블에서 가장 최근에 추가된 선수들을 하나씩 가져옴
        int winnerId = winnerPlayerMapper.findLatest(playingGameId);
        int loserId = loserPlayerMapper.findLatest(playingGameId);

        // 위너 테이블과 루저 테이블에서 가져온 선수들을 테이블에서 제거해줌
        winnerPlayerMapper.delete(winnerId, playingGameId);
        loserPlayerMapper.delete(loserId, playingGameId);

        List<Integer> resetPlayerList = List.of(winnerId, loserId);

        // 다시 플레잉 게임 플레이어 테이블에 담기
        resetPlayerList.forEach(
                p -> playingGamePlayersMapper.save(PlayingGamePlayers.builder()
                        .playingGameId(playingGameId)
                        .playerId(p)
                        .build())
        );

        return findOne(playingGameId);
    }

    public int getGameId(int playingGameId) {
        return playingGameMapper.getGameId(playingGameId);
    }

    // 플레이하던 게임이 있으면 리턴
    public Integer searchByAccountId(String accountId, int gameId) {
        return playingGameMapper.searchByAccountId(accountId, gameId);
    }
}
