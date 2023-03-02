package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
//    Book findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEuqualAndUpdatedAtGreaterThanEqual(String name);

    @Query(value = "select b from Book b where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt and category is null")
    List<Book> findByRecently(@Param("name") String name);
}
