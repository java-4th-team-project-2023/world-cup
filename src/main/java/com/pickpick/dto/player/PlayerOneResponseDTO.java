package com.pickpick.dto.player;

import com.pickpick.entity.Player;
import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class PlayerOneResponseDTO {

    private int playerId;
    private String playerImgPath;
    private String playerName;

    public PlayerOneResponseDTO(Player player) {
        playerId = player.getPlayerId();
        playerImgPath = player.getPlayerImgPath();
        playerName = player.getPlayerName();
    }
}
