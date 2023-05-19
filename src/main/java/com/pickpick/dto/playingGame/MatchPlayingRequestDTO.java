package com.pickpick.dto.playingGame;

import lombok.*;

@Setter @Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class MatchPlayingRequestDTO {

    private int playingGameId;
    private int winnerId;
    private int loserId;

}
