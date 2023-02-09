package com.example.ioctest;

import com.example.ioctest.ioc.encode.Base64Encoder;
import com.example.ioctest.ioc.encode.Encoder;
import com.example.ioctest.ioc.encode.UrlEncoder;
import com.example.ioctest.ioc.provider.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication // spring 실행이 될 때 직접 객체를 싱글톤 형태로 만들어 Spring container에서 관리
public class IocTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocTestApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();
//        //spring형태에서 관리 되는 객체 -> bean
        Encoder encoder = context.getBean("urlEncode", Encoder.class);
        String url = "www.naver.com";
        String result = encoder.encode(url);
        System.out.println(result);

//        encoder.setEncoder(urlEncoder);
//        result = encoder.encode(url);
//        System.out.println(result);
    }
}


// 여러가지 bean을 생성하기 위한 어노테이션

@Configuration
class AppConfig {
    //Bean 네임 같은 경우 component의 이름과 겹치지 않게 조심해야한다.

//    @Bean("base64Encode")
//    public Encoder encoder(Base64Encoder base64Encoder) {
//        return new Encoder(base64Encoder);
//    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}
