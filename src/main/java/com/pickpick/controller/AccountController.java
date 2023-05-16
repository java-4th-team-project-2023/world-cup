package com.pickpick.controller;

import com.pickpick.dto.account.request.LoginRequestDTO;
import com.pickpick.dto.account.request.SignUpRequestDTO;
import com.pickpick.service.AccountService;
import com.pickpick.service.LoginResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.pickpick.service.LoginResult.SUCCESS;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    // 회원가입 요청
//    @GetMapping("/sign-up")
//    public String signUp(){
//        log.info("/account/sign-up GET - forwarding to jsp");
//
//        return "account/sign-up";
//    }

    // 회원가입 처리 요청
    @PostMapping("/sign-up")
    public String signUp(SignUpRequestDTO dto){
        log.info("/account/sign-up POST ! - {}",dto);
        boolean flag = accountService.join(dto);
        return "redirect:/"; // 리스트로 보낼지 어디로 보낼지 상의
    }

//     아이디, 이메일 중복검사
//     비동기 요청 처리
    @GetMapping("/check")
    @ResponseBody
    public ResponseEntity<?> check(String type, String keyword){
        log.info("/account/check?type={}&keyword={} ASYNC GET!", type, keyword);
        boolean flag = accountService.checkSignUpValue(type, keyword);
        return ResponseEntity.ok().body(flag);
    }

    // 로그인 양식 요청
    @GetMapping("/sign-in")
    public String signIn(){
        log.info("/account/sign-in GET - forwarding to jsp");
        return "account/sign-in";
    }
    // 로그인 검증 요청
    @PostMapping("/sign-in")
    public String signIn(LoginRequestDTO dto
                         // 리다이렉션시 2번째 응답에 데이터를 보내기 위함
            , RedirectAttributes attributes
            , HttpServletRequest request){
        log.info("/account/sign-in POST ! - {}",dto);

        LoginResult result = accountService.authenticate(dto);

        // 로그인 성공시
        if (result == SUCCESS) {

            // 세션에 로그인 정보 저장
            accountService.maintainLoginState(request.getSession(),dto.getAccountId());
            return "redirect:/games/list";
        }
        // 1회용으로 쓰고 버릴 데이터
        attributes.addFlashAttribute("msg",result);
        // 로그인 실패시
        return "redirect:/account/sign-in";

    }

    // 로그아웃 요청 처리
    @GetMapping("/sign-out")
    public String signOut(HttpSession session){
        // 세션에서 login정보를 제거
        session.removeAttribute("login");

        // 세션을 아예 초기화 (세션만료 시간)
        session.invalidate();

        return "redirect:/";
    }

}
