package com.example.bookreview.service;

import com.example.bookreview.domain.entity.Gender;
import com.example.bookreview.domain.entity.UserInfo;
import com.example.bookreview.domain.repository.UserInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private EntityManager manager;

    @Transactional
    public void put() {
        UserInfo user = new UserInfo();
        user.setName("Chan");
        user.setEmail("chan@naver.com");
        manager.persist(user);
        user.setGender(Gender.MALE);
    }
}
