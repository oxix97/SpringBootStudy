package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Book;
import com.example.bookreview.domain.repository.dto.BookNameAndCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
//    Book findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEuqualAndUpdatedAtGreaterThanEqual(String name);

    @Query(value = "select b from Book b where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt and category is null")
    List<Book> findByRecently(@Param("name") String name);

//    @Query(value = "select b.name as name, b.category as category from Book  b")
//    List<Tuple> findBookNameAndCategory();

    //페이징 사용
    @Query(value = "select new com.example.bookreview.domain.repository.dto.BookNameAndCategory(b.name, b.category) from Book  b")
    Page<BookNameAndCategory> findBookNameAndCategory(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update book set name = :name", nativeQuery = true)
    int updateNativeQuery(String name);
}
