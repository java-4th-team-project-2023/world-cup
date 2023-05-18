package com.pickpick.service;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.playingGame.PlayingGameAndPlayersResponseDTO;
import com.pickpick.dto.playingGame.PlayingGameListResponseDTO;
import com.pickpick.dto.playingGame.PlayingGameSaveRequestDTO;
import com.pickpick.dto.playingGame.MatchUpdateRequestDTO;
import com.pickpick.entity.PlayingGame;
import com.pickpick.entity.PlayingGamePlayers;
import com.pickpick.repository.PlayingGameMapper;
import com.pickpick.repository.PlayingGamePlayersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayingGameService {

    private final PlayingGameMapper playingGameMapper;
    private final PlayingGamePlayersMapper playingGamePlayersMapper;
    private final PlayerService playerService;

    public int saveGameAndPlayers(PlayingGameSaveRequestDTO dto) {

        // 우선 플레이중인 게임을 만든 뒤 id를 리턴받는다.
        int playingGameId = playingGameMapper.save(PlayingGame.builder()
                .gameId(dto.getGameId())
                .totalRound(dto.getTotalRound())
                .accountId(dto.getAccountId())
                .currentRound(dto.getCurrentRound())
                .build());
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

}
