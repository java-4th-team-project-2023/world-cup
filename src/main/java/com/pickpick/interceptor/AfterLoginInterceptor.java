package com.pickpick.interceptor;

import com.pickpick.util.LoginUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.pickpick.util.LoginUtil.*;

@Configuration
// 로그인 이후 비회원 관련 페이지 진입 차단
public class AfterLoginInterceptor
        implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        if (isLogin(session)) {
            response.sendRedirect("/account/sign-in");
            return false;
        }
        return true;
    }
}