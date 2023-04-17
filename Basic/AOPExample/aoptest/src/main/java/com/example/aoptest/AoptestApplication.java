package com.example.aoptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@SpringBootApplication
public class AoptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AoptestApplication.class, args);
        System.out.println(Base64.getEncoder().encodeToString("ieejo716@naver.com".getBytes()));
    }

}
