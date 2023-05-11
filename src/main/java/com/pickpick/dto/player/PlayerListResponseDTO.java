package com.pickpick.dto.player;

import com.pickpick.entity.Player;
import lombok.*;

@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class PlayerListResponseDTO {

    private String playerId;
    private double matchWinRate;
    private double finalWinRate;
    private String playerImgPath;
    private String playerName;

    public PlayerListResponseDTO(Player player) {

    }

}
