package com.pickpick.dto.player;

import com.pickpick.dto.page.PageMaker;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
@Builder
public class PlayerRestListResponseDTO {
    private PageMaker pageInfo;
    private int count;
    private List<PlayerListResponseDTO>  playerList;
}
