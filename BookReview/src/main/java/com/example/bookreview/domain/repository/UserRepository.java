package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
