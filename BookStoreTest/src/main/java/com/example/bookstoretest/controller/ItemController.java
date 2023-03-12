package com.example.bookstoretest.controller;

import com.example.bookstoretest.dto.ItemData;
import com.example.bookstoretest.entity.Book;
import com.example.bookstoretest.entity.Item;
import com.example.bookstoretest.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item/book")
public class ItemController {
    private final ItemService service;
    private ObjectMapper mapper;

    @GetMapping("/{name}")
    public ItemData getItem(
            @PathVariable String name
    ) {
        Book item = (Book) service.findByName(name);
        return entityToDto(item);
    }

    @PostMapping("/save")
    public ItemData saveItem(
            @RequestBody Book book
    ) {
        service.saveItem(book);
        return entityToDto(book);
    }


    private ItemData entityToDto(Book item) {
        return ItemData.builder()
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .build();
    }
}
