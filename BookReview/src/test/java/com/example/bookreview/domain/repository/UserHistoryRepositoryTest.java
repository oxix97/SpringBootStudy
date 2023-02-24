package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Gender;
import com.example.bookreview.domain.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserHistoryRepositoryTest {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserHistoryRepository historyRepository;

    @Test
    void userInsertTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("chan");
        userInfo.setEmail("ieejo");
        userInfo.setGender(Gender.MALE);
        userInfoRepository.save(userInfo);
    }

    @Test
    void userHistoryTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Chan");
        userInfo.setEmail("chan@naver.com");
        userInfo.setGender(Gender.FEMALE);
        userInfoRepository.save(userInfo);

        userInfo.setEmail("chan@kakao.com");
        userInfoRepository.save(userInfo);

        userInfo.setGender(Gender.MALE);
        userInfoRepository.save(userInfo);

        historyRepository.findAll().forEach(System.out::println);
    }

}