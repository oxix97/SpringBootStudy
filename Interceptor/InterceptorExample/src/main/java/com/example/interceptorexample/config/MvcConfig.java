package com.example.interceptorexample.config;

import com.example.interceptorexample.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns에 내가 원하는 주소만 넣어도 된다.
        registry.addInterceptor(authInterceptor);
        //해당 인터셉터를 추가하게 되면 단계적으로 실행하여 부가적으로 로직을 구현하여도 좋다.
    }
}
