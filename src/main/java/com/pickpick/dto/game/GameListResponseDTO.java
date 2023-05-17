package com.pickpick.dto.game;

import com.pickpick.entity.Game;
import lombok.*;

import java.util.List;

@Getter @Setter @Builder
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class GameListResponseDTO {

    private int gameId; // PK
    private String gameName;
    private int playCount;
    private String accountId; // FK
    private List<String > thumbnails;

    public GameListResponseDTO(Game game, List<String> thumbnails) {

        this.gameId = game.getGameId();
        this.gameName = game.getGameName();
        this.playCount = game.getPlayCount();
        this.accountId = game.getAccountId();
        this.thumbnails = thumbnails;

    }

}
