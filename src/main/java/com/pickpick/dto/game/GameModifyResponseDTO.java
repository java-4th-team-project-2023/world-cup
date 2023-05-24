package com.pickpick.dto.game;

import com.pickpick.dto.player.PlayerListResponseDTO;
import com.pickpick.entity.Game;
import lombok.*;

import java.util.List;

@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode @ToString
public class GameModifyResponseDTO {

    private int gameId;
    private String gameName;
    private List<PlayerListResponseDTO> playerList;

    public GameModifyResponseDTO(Game game, List<PlayerListResponseDTO> playerList) {
        this.gameId = game.getGameId();
        this.gameName = game.getGameName();
        this.playerList = playerList;
    }

}
