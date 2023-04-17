package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByName(String name);

    UserInfo findByEmail(String email);
}
