package com.pickpick.entity;

import lombok.*;

import java.time.LocalDateTime;

/*
CREATE TABLE reply_tbl (
    reply_no int(9) AUTO_INCREMENT,
    game_id int(9) NOT NULL,
    writer VARCHAR(50) NOT NULL,
    text VARCHAR(1000) NOT NULL,
    date DATETIME DEFAULT CURRENT_TIMESTAMP,
    like_count int(9) default 0,
    CONSTRAINT pk_reply_no PRIMARY KEY (reply_no),
    CONSTRAINT fk_game_id_reply FOREIGN KEY (game_id) REFERENCES game_tbl(game_id)
                       ON DELETE CASCADE
);
 */

@Setter @Getter
@EqualsAndHashCode @ToString
@Builder @NoArgsConstructor @AllArgsConstructor
public class Reply {

    private int replyNo; // pk
    private int gameId; // fk
    private String writer;
    private String text;
    private LocalDateTime date;

}
