package com.pickpick.entity;

import lombok.*;

import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class PlayingGame {

    private int playingGameId;
    private int gameId;
    private int totalRound;
    private int currentRound;
    private String accountId;

}


