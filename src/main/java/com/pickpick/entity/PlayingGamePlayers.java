package com.pickpick.entity;

import lombok.*;

@Setter @Getter @Builder
@EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class PlayingGamePlayers {

    private int playingGameId;
    private int playerId;

}
