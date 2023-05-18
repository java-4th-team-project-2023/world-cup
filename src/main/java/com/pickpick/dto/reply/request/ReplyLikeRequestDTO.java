package com.pickpick.dto.reply.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ReplyLikeRequestDTO {
    private int gameId;
    private int replyNo;
}
