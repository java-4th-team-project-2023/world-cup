package com.pickpick.dto.playingGame;

import com.pickpick.entity.PlayingGamePlayers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class PlayingGameSaveRequestDTO {

    @NotNull
    private Integer gameId;
    @NotNull
    private Integer totalRound;
    @NotBlank
    private String accountId;
    @NotNull
    private Integer currentRound;
    @NotNull
    private List<PlayingGamePlayers> players;

}
