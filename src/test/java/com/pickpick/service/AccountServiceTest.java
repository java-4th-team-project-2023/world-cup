package com.pickpick.service;

import com.pickpick.dto.account.request.LoginRequestDTO;
import com.pickpick.dto.account.request.SignUpRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountService accountService;
    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("회원가입이 정상적으로 되어야한다")
    void joinTest(){

        SignUpRequestDTO dto = new SignUpRequestDTO();
        dto.setAccountId("oslob99");
        dto.setEmail("qqqqq");
        dto.setPassword("1");

        boolean flag = accountService.join(dto);

        assertTrue(flag);
    }

    @Test
    @DisplayName("아이디와 이메일 중복검사가 제대로 되어야한다")
    void checkTest(){
        String type = "accountId";
        String keyword = "aaa";

        boolean flag = accountService.checkSignUpValue(type, keyword);
        assertTrue(flag);
    }

    @Test
    @DisplayName("로그인인증이 제대로 되어야한다")
    void authTest(){
        LoginRequestDTO dto = new LoginRequestDTO();
        dto.setAccountId("aaa");
        dto.setPassword("1234");
//        encoder.matches(dto.setPassword(),"1234");



    }

}