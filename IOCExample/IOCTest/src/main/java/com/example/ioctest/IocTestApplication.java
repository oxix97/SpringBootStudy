package com.example.ioctest;

import com.example.ioctest.ioc.encode.Base64Encoder;
import com.example.ioctest.ioc.encode.Encoder;
import com.example.ioctest.ioc.encode.UrlEncoder;
import com.example.ioctest.ioc.provider.ApplicationContextProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // spring 실행이 될 때 직접 객체를 싱글톤 형태로 만들어 Spring container에서 관리
public class IocTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocTestApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
        Encoder encoder = new Encoder(base64Encoder);
        String url = "www.naver.com";

        String result = encoder.encode(url);
        System.out.println(result);

        encoder.setEncoder(urlEncoder);
        result = encoder.encode(url);
        System.out.println(result);
    }
}
