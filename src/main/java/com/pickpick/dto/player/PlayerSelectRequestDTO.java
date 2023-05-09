package com.pickpick.dto.player;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PlayerSelectRequestDTO {

    @NotNull
    @Min(0) @Max(Integer.MAX_VALUE)
    private int playerId;

    private int fightCount;

    private int selectedWinCount;

    private int joinGameCount;

    private int finalWinCount;

}
