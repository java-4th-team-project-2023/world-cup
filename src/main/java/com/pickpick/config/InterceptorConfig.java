package com.pickpick.config;

import com.pickpick.interceptor.AfterLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 다양한 인터셉터에 관련 설정을 등록하는 클래스
@Configuration
@RequiredArgsConstructor
public class InterceptorConfig
        implements WebMvcConfigurer {

    private  final AfterLoginInterceptor afterLoginInterceptor;
    // 인터셉터 설정 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 로그인 후처리 인터셉터 설정
        registry.addInterceptor(afterLoginInterceptor)
                .addPathPatterns("/account/sign-in","/account/sign-up")
        ;

    }
}