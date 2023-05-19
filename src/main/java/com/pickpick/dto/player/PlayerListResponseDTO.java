package com.pickpick.dto.player;

import com.pickpick.entity.Player;
import lombok.*;

@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class PlayerListResponseDTO {

    private int playerId;
    private double matchWinRate;
    private double finalWinRate;
    private String playerImgPath;
    private String playerName;

    public PlayerListResponseDTO(Player player) {
        playerId = player.getPlayerId();
        try {
            matchWinRate = (double) player.getSelectedWinCount() / player.getFightCount() * 100;
        } catch (ArithmeticException e) {
            matchWinRate = 0.0;
        }
        try {
            finalWinRate = (double) player.getFinalWinCount() / player.getJoinGameCount() * 100;
        } catch (ArithmeticException e) {
            finalWinRate = 0.0;
        }
        playerImgPath = player.getPlayerImgPath();
        playerName = player.getPlayerName();
    }

}
