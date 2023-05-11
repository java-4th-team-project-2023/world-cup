package com.pickpick.dto.player;

import com.pickpick.entity.Player;
import lombok.*;

@Getter @Setter @Builder
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class PlayerGameResponseDTO {

    private int playerId;
    private String playerImgPath;
    private String playerName;

    public PlayerGameResponseDTO(Player player) {
        playerId = player.getPlayerId();
        playerImgPath = player.getPlayerImgPath();
        playerName = player.getPlayerName();
    }

}
