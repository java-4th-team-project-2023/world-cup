package com.pickpick.dto.account.request;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class LoginRequestDTO {

    private String accountId;
    private String password;
}
