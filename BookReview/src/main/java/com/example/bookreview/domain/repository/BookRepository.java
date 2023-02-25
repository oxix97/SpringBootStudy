package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

}
