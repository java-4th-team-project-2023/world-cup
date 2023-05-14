package com.pickpick.service;

import com.pickpick.dto.playingGame.PlayingGameSaveRequestDTO;
import com.pickpick.dto.playingGame.MatchUpdateRequestDTO;
import com.pickpick.entity.PlayingGame;
import com.pickpick.entity.PlayingGamePlayers;
import com.pickpick.repository.PlayingGameMapper;
import com.pickpick.repository.PlayingGamePlayersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
