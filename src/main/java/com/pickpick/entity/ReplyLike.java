package com.pickpick.entity;

/*
create table reply_like_tbl(
	account_id VARCHAR(50),
	reply_no int(9)
);
 */
import lombok.*;

@Setter @Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyLike {

    private int replyNo;
    private String accountId;
}
