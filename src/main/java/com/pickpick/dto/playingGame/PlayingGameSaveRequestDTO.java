package com.pickpick.dto.playingGame;

import com.pickpick.entity.PlayingGamePlayers;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter @Getter @Builder
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class PlayingGameSaveRequestDTO {

    @NotNull
    private Integer gameId;
    @NotNull
    private Integer totalRound;

    private String accountId;
    @NotNull
    private Integer currentRound;
    @NotNull
    private List<Integer> playerIdList;

}
