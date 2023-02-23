package com.example.basic.jpa.manager.repository;

import com.example.basic.jpa.manager.domain.BookHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookHistoryRepository extends JpaRepository<BookHistory, Long> {
    BookHistory findByName(String name);
}
