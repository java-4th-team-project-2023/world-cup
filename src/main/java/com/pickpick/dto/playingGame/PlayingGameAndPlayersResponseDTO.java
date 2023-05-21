package com.pickpick.dto.playingGame;

import com.pickpick.dto.player.PlayerOneResponseDTO;
import com.pickpick.entity.Player;
import com.pickpick.entity.PlayingGamePlayers;
import lombok.*;

import java.util.List;

@Setter @Getter @Builder
@EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class PlayingGameAndPlayersResponseDTO {

    private int totalRound;
    private int currentRound;
    private List<PlayerOneResponseDTO> randomTwoPlayers;
    private int gameId;

}
