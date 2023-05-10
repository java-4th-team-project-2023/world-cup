package com.pickpick.dto.reply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pickpick.entity.Reply;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDetailResponseDTO {

    private int gameId;
    private String text;
    private String writer;
    @JsonFormat(pattern = "yyyy년 MM월 dd일 HH:mm")
    private LocalDateTime date;

    public ReplyDetailResponseDTO(Reply reply){
        this.gameId = reply.getGameId();
        this.text = reply.getText();
        this.writer = reply.getWriter();
        this.date = reply.getDate();
    }
}
