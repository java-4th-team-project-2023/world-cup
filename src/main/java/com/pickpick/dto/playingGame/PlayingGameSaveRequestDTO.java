package com.pickpick.dto.playingGame;

import com.pickpick.entity.PlayingGamePlayers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class PlayingGameSaveRequestDTO {

    private int gameId;
    private int totalRound;
    private String accountId;
    private int currentRound;
    private List<PlayingGamePlayers> players;

}
