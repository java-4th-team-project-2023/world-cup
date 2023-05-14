package com.pickpick.dto.playingGame;

import com.pickpick.entity.PlayingGamePlayers;
import lombok.*;

import java.util.List;

@Setter @Getter @Builder
@EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class PlayingGameAndPlayersResponseDTO {

    private int playingGameId;
    private int gameId;
    private int totalRound;
    private int currentRound;
    private List<PlayingGamePlayers> players;

}
