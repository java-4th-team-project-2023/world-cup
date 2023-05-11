package com.pickpick.dto.player;

import com.pickpick.entity.Player;
import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class PlayerOneResponseDTO {

    private String playerImgPath;
    private String playerName;

    public PlayerOneResponseDTO(Player player) {
        playerImgPath = player.getPlayerImgPath();
        playerName = player.getPlayerName();
    }
}
