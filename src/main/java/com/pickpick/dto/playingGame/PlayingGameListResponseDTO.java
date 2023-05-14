package com.pickpick.dto.playingGame;

import com.pickpick.entity.PlayingGame;
import lombok.*;

@Getter @Setter
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class PlayingGameListResponseDTO {

     private int playingGameId;
     private int gameId;
     private int totalRound;
     private int currentRound;

     public PlayingGameListResponseDTO(PlayingGame game) {
          this.playingGameId = game.getPlayingGameId();
          this.gameId = game.getGameId();
          this.totalRound = game.getTotalRound();
          this.currentRound = game.getCurrentRound();
     }

}
