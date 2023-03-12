package com.example.bookstoretest.repository;

import com.example.bookstoretest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
}
