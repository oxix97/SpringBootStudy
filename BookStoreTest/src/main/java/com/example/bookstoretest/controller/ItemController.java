package com.example.bookstoretest.controller;

import com.example.bookstoretest.dto.ItemData;
import com.example.bookstoretest.entity.Book;
import com.example.bookstoretest.entity.Item;
import com.example.bookstoretest.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item/book")
public class ItemController {
    private final ItemService service;
    private ObjectMapper mapper;

    @GetMapping("/{name}")
    public ItemData getBook(
            @PathVariable String name
    ) {
        Book item = (Book) service.findByName(name);
        return entityToDto(item);
    }

    @PostMapping("/save")
    public ItemData saveBook(
            @RequestBody Book book
    ) {
        service.saveItem(book);
        return entityToDto(book);
    }

    @GetMapping("/find-all")
    public List<ItemData> getAllBooks() {
        var stream = service.findAllItems().stream().map(item -> entityToDto((Book) item));
        return stream.toList();
    }


    private ItemData entityToDto(Book item) {
        return ItemData.builder()
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .build();
    }
}
