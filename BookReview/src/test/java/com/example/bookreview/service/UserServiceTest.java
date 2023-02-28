package com.example.bookreview.service;

import com.example.bookreview.domain.repository.UserInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService service;
    @Autowired
    UserInfoRepository repository;

    @Test
    void test() {
        service.put();

        System.out.println("---------- : "+repository.findByEmail("chan@naver.com"));
    }
}