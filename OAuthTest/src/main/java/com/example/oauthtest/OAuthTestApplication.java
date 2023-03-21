package com.example.oauthtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class OAuthTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthTestApplication.class, args);
    }

}
