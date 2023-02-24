package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Gender;
import com.example.bookreview.domain.entity.UserHistory;
import com.example.bookreview.domain.entity.UserInfo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserHistoryRepositoryTest {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserHistoryRepository historyRepository;

    @BeforeEach()
    void initUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("chan");
        userInfo.setEmail("ieejo");
        userInfo.setGender(Gender.MALE);
        userInfoRepository.save(userInfo);

        userInfo.setName("Chan");
        userInfo.setEmail("chan@naver.com");
        userInfo.setGender(Gender.FEMALE);
        userInfoRepository.save(userInfo);

        userInfo.setEmail("chan@kakao.com");
        userInfoRepository.save(userInfo);

        userInfo.setGender(Gender.MALE);
        userInfoRepository.save(userInfo);
    }

    @Test
    void userHistoryTest() { // 1대 N 연관
        for (UserInfo data : userInfoRepository.findAll()) {
            System.out.println(data);
            data.getUserHistories().forEach(System.out::println);
        }
    }

    @Test
    void userHaveHistoryTest() { // N대 1 연관
        historyRepository.findAll().forEach(System.out::println);
    }
}