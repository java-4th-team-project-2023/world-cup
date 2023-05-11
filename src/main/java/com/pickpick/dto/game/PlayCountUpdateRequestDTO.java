package com.pickpick.dto.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@NoArgsConstructor
@ToString
public class PlayCountUpdateRequestDTO {

    private int gameId;
    private int playCount;

}
