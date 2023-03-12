package com.example.bookstoretest.repository;

import com.example.bookstoretest.entity.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordered, Long> {

}