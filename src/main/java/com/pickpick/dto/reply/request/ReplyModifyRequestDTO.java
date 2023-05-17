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

    private String writer;
    private String text;
    private int gameId;

    public Reply toEntity(){
        return Reply.builder()
                .gameId(this.gameId)
                .writer(this.writer)
                .text(this.text)
                .build();
    }
}
