package com.pickpick.dto.playingGame;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class MatchUpdateRequestDTO {

    @NotNull
    private Integer playingGameId;
    @NotNull
    private List<Integer> losers;

}
