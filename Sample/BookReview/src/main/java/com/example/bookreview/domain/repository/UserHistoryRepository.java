package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

}
