package com.pickpick.dto.player;

import com.pickpick.entity.Player;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@AllArgsConstructor @Builder
public class PlayerRegisterRequestDTO {

    @NotNull
    @Min(0) @Max(Integer.MAX_VALUE)
    private int gameId;

    @NotNull
    private String playerImgPath;

    @NotNull
    private String playerName;

    public Player toEntity() {
        return Player.builder()
                .gameId(gameId)
                .playerName(playerName)
                .playerImgPath(playerImgPath)
                .build();
    }

}
