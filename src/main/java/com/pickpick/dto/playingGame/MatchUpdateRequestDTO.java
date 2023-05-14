package com.pickpick.dto.playingGame;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class MatchUpdateRequestDTO {

    private int playingGameId;
    private int loser;

}
