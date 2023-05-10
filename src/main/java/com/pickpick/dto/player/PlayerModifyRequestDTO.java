package com.pickpick.dto.player;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
@Builder
public class PlayerModifyRequestDTO {

    private int playerId;
    private String playerName;
    private String playerImgPath;

}
