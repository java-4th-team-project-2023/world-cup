package com.pickpick.entity;

import lombok.*;

/*
CREATE TABLE account_tbl (
    account_id VARCHAR(50),
    password VARCHAR(150) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    auth VARCHAR(20) DEFAULT 'COMMON',
    CONSTRAINT pk_account_id PRIMARY KEY (account_id)
);
 */

@Getter @Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private String accountId; // pk
    private String password;
    private String email;
    private Auth auth;

}
