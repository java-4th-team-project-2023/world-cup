package com.pickpick.entity;

import lombok.*;
/*
CREATE TABLE game_tbl (
  game_id int(9) AUTO_INCREMENT,
  game_name VARCHAR(50) NOT NULL,
  play_count int(9) DEFAULT 0,
  account_id VARCHAR(50),
  CONSTRAINT pk_game_id PRIMARY KEY (game_id),
  CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES account_tbl(account_id)
            ON DELETE CASCADE
);
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

    private int gameId; // PK
    private String gameName;
    private int playCount;
    private String accountId; // FK

}
