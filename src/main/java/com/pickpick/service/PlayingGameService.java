package com.pickpick.service;

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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayingGameService {

    private final PlayingGameMapper playingGameMapper;
    private final PlayingGamePlayersMapper playingGamePlayersMapper;

    public void saveGameAndPlayers(PlayingGameSaveRequestDTO dto) {
        playingGameMapper.save(PlayingGame.builder()
                .gameId(dto.getGameId())
                .totalRound(dto.getTotalRound())
                .accountId(dto.getAccountId())
                .currentRound(dto.getCurrentRound())
                .build());
        dto.getPlayers()
                .forEach(playingGamePlayersMapper::save);
    }

    public void updateEndOfMatch(MatchUpdateRequestDTO dto) {

        // 진사람 삭제
        playingGamePlayersMapper.delete(PlayingGamePlayers.builder()
                        .playingGameId(dto.getPlayingGameId())
                        .playerId(dto.getLoser())
                .build());

    }

    public void resetMatch(MatchUpdateRequestDTO dto) {

        // 진사람 복구
        playingGamePlayersMapper.save(PlayingGamePlayers.builder()
                        .playingGameId(dto.getPlayingGameId())
                        .playerId(dto.getLoser())
                .build());

    }

    public void updateEndOfRound(int playingGameId) {

        // 현재 라운드를 2로 나눈 후 업데이트
        playingGameMapper.update(PlayingGame.builder()
                        .playingGameId(playingGameId)
                        .currentRound(playingGameMapper.findOne(playingGameId)
                                .getCurrentRound() >> 1)
                .build());

    }

    public void resetEndOfRound(int playingGameId) {

        // 라운드 리셋
        playingGameMapper.update(PlayingGame.builder()
                        .playingGameId(playingGameId)
                        .currentRound(playingGameMapper.findOne(playingGameId).getCurrentRound() * 2)
                .build());

    }

    public void deletePlayingGame(int playingGameId) {

        playingGameMapper.delete(playingGameId);

    }

    public PlayingGameAndPlayersResponseDTO findOne(int playingGameId) {

        PlayingGame game = playingGameMapper.findOne(playingGameId);
        List<PlayingGamePlayers> players = playingGamePlayersMapper.findAllByGameId(playingGameId);

        return PlayingGameAndPlayersResponseDTO.builder()
                .playingGameId(game.getPlayingGameId())
                .gameId(game.getGameId())
                .totalRound(game.getTotalRound())
                .currentRound(game.getCurrentRound())
                .players(players)
                .build();

    }

    public List<PlayingGameListResponseDTO> findAll(int accountId) {

        return playingGameMapper.findByAccountId(accountId).stream()
                .map(PlayingGameListResponseDTO::new)
                .collect(Collectors.toList());

    }
}
