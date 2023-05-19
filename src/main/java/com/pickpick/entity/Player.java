package com.pickpick.entity;

import lombok.*;

/*
CREATE TABLE player_tbl (
    entity_id int(9) AUTO_INCREMENT,
    game_id int(9) NOT NULL,
    fight_count int(9) DEFAULT 0,
    selected_win_count int(9) DEFAULT 0,
    join_game_count int(9) DEFAULT 0,
    final_win_count int(9) DEFAULT 0,
    entity_img_path VARCHAR(1000) NOT NULL,
    entity_name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_entity_id PRIMARY KEY (entity_id),
    CONSTRAINT fk_game_id FOREIGN KEY (game_id) REFERENCES game_tbl(game_id)
                                 ON DELETE CASCADE
);
 */
@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
    private int playerId; // PK
    private int gameId; // FK
    private int fightCount;
    private int selectedWinCount;
    private int joinGameCount;
    private int finalWinCount;
    private String playerImgPath;
    private String playerName;

    public boolean increaseFightCount() {
        fightCount++;
        return true;
    }

    public boolean joinGame() {
        joinGameCount++;
        return true;
    }

    public boolean winFight() {
        selectedWinCount++;
        increaseFightCount();
        return true;
    }

    public boolean winFinal() {
        finalWinCount++;
        return winFight();
    }

    public boolean decreaseFightCount() {
        if (fightCount == 0) return false;
        fightCount--;
        return true;
    }

    public boolean decreaseSelectedCount() {
        if (!decreaseFightCount()) return false;

        if (selectedWinCount == 0) return false;
        selectedWinCount--;
        return true;
    }

}
