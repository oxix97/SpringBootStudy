package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
}
