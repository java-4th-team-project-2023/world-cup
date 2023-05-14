package com.pickpick.service;

import com.pickpick.dto.playingGame.PlayingGameSaveRequestDTO;
import com.pickpick.dto.playingGame.PlayingGameUpdateRequestDTO;
import com.pickpick.entity.PlayingGame;
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

    public void updateEndOfRound(PlayingGameUpdateRequestDTO dto) {



    }
}
