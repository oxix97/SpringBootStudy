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

        //service 단계에서 save로 인해 수정 사항을 db에 저장하지 않더라고 1차캐시와 비교하여 저장한 이후 반영한다.
        //이는
        System.out.println("---------------");
        System.out.println("---------- : "+repository.findByEmail("chan@naver.com"));
    }
}