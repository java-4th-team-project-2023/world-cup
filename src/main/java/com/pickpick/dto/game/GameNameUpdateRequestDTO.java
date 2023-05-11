package com.pickpick.dto.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class GameNameUpdateRequestDTO {

    private int gameId;
    private String gameName;

}
