package com.pickpick.dto.player;

import com.pickpick.entity.Player;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@AllArgsConstructor @Builder
public class PlayerRegisterRequestDTO {

    private int gameId;
    private String playerImgPath;
    private String playerName;

    public Player toEntity() {
        return Player.builder()
                .gameId(gameId)
                .playerName(playerName)
                .playerImgPath(playerImgPath)
                .build();
    }

}
