package com.pickpick.entity;

import lombok.*;

/*
 create table reply_report_tbl(
	account_id VARCHAR(50),
	reply_no int(9)
);
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyReport {

    private int replyNo;
    private String accountId;
}
