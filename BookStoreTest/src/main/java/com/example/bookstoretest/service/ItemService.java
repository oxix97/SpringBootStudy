package com.example.bookstoretest.service;

import com.example.bookstoretest.entity.Item;
import com.example.bookstoretest.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository repository;

    public void saveItem(Item item) {
        repository.save(item);
    }

    public List<Item> findAllItems() {
        return repository.findAll();
    }

    public Item findByItemId(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
