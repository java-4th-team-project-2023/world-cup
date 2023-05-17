package com.pickpick.dto.game;

import lombok.*;

@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameInsertRequestDTO {

    private String gameName;
    private String  accountId;

}
