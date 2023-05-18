package com.pickpick.dto.reply.response;

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
    private int replyNo;
    private String text;
    private String writer;
    @JsonFormat(pattern = "yyyy년 MM월 dd일 HH:mm")
    private LocalDateTime date;
    private String accountId;

    public ReplyDetailResponseDTO(Reply reply){
        this.replyNo = reply.getReplyNo();
        this.gameId = reply.getGameId();
        this.text = reply.getText();
        this.writer = reply.getWriter();
        this.date = reply.getDate();
        this.accountId = reply.getAccountId();
    }
}
