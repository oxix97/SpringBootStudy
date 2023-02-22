package com.example.basic.jpa.manager.repository;

import com.example.basic.jpa.manager.domain.UserData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//spirng data library가 지원해주는 영역 -> 많은 method 지원
public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData findByEmail(String email);

    UserData findById(int id);

    List<UserData> findAllByName(String name);

    UserData findSomethingByEmail(String email);

    UserData findByNameAndEmail(String name, String email);

    List<UserData> findByNameOrEmail(String name, String email);

    List<UserData> findFirstByName(String name);

    Page<UserData> findPageByName(String name, PageRequest id);

    Slice<UserData> findSliceByName(String name);
}
