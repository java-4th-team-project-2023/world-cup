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
    @DisplayName("회원이 정상적으로 저장되어야한다")
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

    @Test
    @DisplayName("aaa계정을 찾아서 계정의 정보를 가져와야한다")
    void findAccountTest(){
        String accountId = "aaa";

        Account account = accountMapper.findAccount(accountId);

        System.out.println("account = " + account.toString());

    }
}