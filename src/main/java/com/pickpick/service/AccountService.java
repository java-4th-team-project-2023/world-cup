package com.pickpick.service;

import com.pickpick.dto.account.request.LoginRequestDTO;
import com.pickpick.dto.account.request.SignUpRequestDTO;
import com.pickpick.dto.account.response.LoginUserResponseDTO;
import com.pickpick.entity.Account;
import com.pickpick.repository.AccountMapper;
import com.pickpick.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static com.pickpick.service.LoginResult.*;
import static com.pickpick.util.LoginUtil.LOGIN_KEY;
import static com.pickpick.util.LoginUtil.isLogin;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final PasswordEncoder encoder;


    // 회원가입 기능
    public boolean join(SignUpRequestDTO dto, HttpSession session) {

        Account account = Account.builder()
                .accountId(dto.getAccountId())
                .password(encoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .build();

        boolean flag = accountMapper.signUp(account);

        maintainLoginState(session,account.getAccountId());
        return flag;
    }

    // 아이디, 이메일 중복검사
    public boolean checkSignUpValue(String type, String keyword) {

        int flagNum = accountMapper.isDuplicate(type, keyword);
        log.info("flagNum: {}", flagNum);
        return flagNum == 1;
    }

    // 회원 정보를 가져오는 기능
    public Account findAccount(String accountId){
        return accountMapper.findAccount(accountId);
    }

    // 로그인 인증
    public LoginResult authenticate(LoginRequestDTO dto) {
        Account foundAccount = accountMapper.findAccount(dto.getAccountId());

        // 회원가입 여부 확인
        if (foundAccount == null) {
            log.info("{} - 존재하지 않는 아이디입니다",dto.getAccountId());
            return ACC_FAIL;
        }
        // 비밀번호 일치 확인
        if (!encoder.matches(dto.getPassword(), foundAccount.getPassword())){
            log.info("비밀번호 틀렸다고!!");
            return PWD_FAIL;
        }

        return SUCCESS;
    }

    // 로그인, 회원가입 성공 후 세션에 로그인한 회원의 정보들을 저장
    public void maintainLoginState(HttpSession session, String accountId) {

        // 로그인 한 회원정보
        Account account = findAccount(accountId);

        LoginUserResponseDTO responseDTO = LoginUserResponseDTO.builder()
                .accountId(account.getAccountId())
                .email(account.getEmail())
                .auth(account.getAuth().toString())
                .build();

        session.setAttribute(LOGIN_KEY,responseDTO);
        session.setMaxInactiveInterval(60 * 60); // 1시간동안 세션유지
        // 로그인 한 회원의 정보 session 담긴지 확인하는 주석
//        System.out.println("!!!!!!!!!!!!!"+ session.getAttribute(LOGIN_KEY) );
//        log.info("!!!!!!!!!!!!!"+ session.getAttribute(LOGIN_KEY) );
//        boolean flag = isLogin(session);
//        System.out.println("!!!!!!!!!!!!!!!!!flag = " + flag);
    }
}
