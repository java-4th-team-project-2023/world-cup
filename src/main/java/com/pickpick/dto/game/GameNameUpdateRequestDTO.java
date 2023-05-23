package com.pickpick.dto.game;

import lombok.*;

@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameNameUpdateRequestDTO {

    private int gameId;
    private String gameName;

}
