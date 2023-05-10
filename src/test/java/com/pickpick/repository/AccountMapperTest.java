package com.pickpick.repository;

import com.pickpick.entity.Account;
import com.pickpick.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    @DisplayName("댓글이 정상적으로 저장되어야한다")
    @Transactional
    void signTest(){
        // given
        Account account = Account.builder()
                .accountId("aaa")
                .password("1234")
                .email("aaaa")
                .build();
        boolean flag = accountMapper.signUp(account);

        assertTrue(flag);
    }
}