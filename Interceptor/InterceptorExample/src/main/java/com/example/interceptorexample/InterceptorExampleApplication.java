package com.example.interceptorexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan
@SpringBootApplication
public class InterceptorExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterceptorExampleApplication.class, args);
    }

}
