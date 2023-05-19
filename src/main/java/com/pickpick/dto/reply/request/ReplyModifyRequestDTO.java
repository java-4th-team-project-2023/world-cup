package com.pickpick.dto.reply.request;

import com.pickpick.entity.Reply;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ReplyModifyRequestDTO {

    private String accountId;
    private String text;
    private int gameId;
    private int replyNo;

    public Reply toEntity(){
        return Reply.builder()
                .gameId(this.gameId)
                .replyNo(this.replyNo)
                .text(this.text)
                .build();
    }
}
