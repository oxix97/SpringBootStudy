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

    private UserInfo userInfo;

    @BeforeEach()
    void initUser() {
        userInfo = new UserInfo();
        userInfo.setName("chan");
        userInfo.setEmail("ieejo");
        userInfo.setGender(Gender.MALE);
        userInfoRepository.save(userInfo);
    }

    @Test
    void userHistoryTest() {
        userInfo.setName("Chan");
        userInfo.setEmail("chan@naver.com");
        userInfo.setGender(Gender.FEMALE);
        userInfoRepository.save(userInfo);

        userInfo.setEmail("chan@kakao.com");
        userInfoRepository.save(userInfo);

        userInfo.setGender(Gender.MALE);
        userInfoRepository.save(userInfo);
        historyRepository.findAll().forEach(System.out::println);
        System.out.println(userInfo);
    }

    @Test
    void emailFindUserHistory() {
        userHistoryTest();
        UserInfo user = userInfoRepository.findByEmail("chan@kakao.com");
        List<UserHistory> histories = user.getUserHistories();
        histories.forEach(System.out::println);
    }
}