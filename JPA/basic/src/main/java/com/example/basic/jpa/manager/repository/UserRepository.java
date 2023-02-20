package com.example.basic.jpa.manager.repository;

import com.example.basic.jpa.manager.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

//spirng data library가 지원해주는 영역 -> 많은 method 지원
public interface UserRepository extends JpaRepository<UserData, Long> {

}
