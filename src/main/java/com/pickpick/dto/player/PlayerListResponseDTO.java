package com.pickpick.dto.player;

import com.pickpick.entity.Player;
import lombok.*;

import java.text.DecimalFormat;

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
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            matchWinRate = Double.parseDouble(decimalFormat.format((float) player.getSelectedWinCount() / player.getFightCount() * 100));
            finalWinRate = Double.parseDouble(decimalFormat.format((float) player.getFinalWinCount() / player.getJoinGameCount() * 100));

        } catch (ArithmeticException e) {
            e.printStackTrace();
            matchWinRate = 0;
            finalWinRate = 0;
        }

        playerImgPath = player.getPlayerImgPath();
        playerName = player.getPlayerName();
    }

}
