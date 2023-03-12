package com.example.bookstoretest.controller;

import com.example.bookstoretest.dto.ItemData;
import com.example.bookstoretest.dto.ResponseData;
import com.example.bookstoretest.entity.Book;
import com.example.bookstoretest.entity.Item;
import com.example.bookstoretest.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item/book")
public class ItemController {
    private final ItemService service;
    private ObjectMapper mapper;

    @GetMapping("/{name}")
    public ResponseData<?> getBook(
            @PathVariable String name
    ) {
        Book item = (Book) service.findByName(name);
        return entityToDto(item);
    }

    @PostMapping("/save")
    public ResponseData<?> saveBook(
            @RequestBody Book book
    ) {
        service.saveItem(book);
        return entityToDto(book);
    }

    @GetMapping("/find-all")
    public ResponseData<?> getAllBooks() {
        var data = service.findAllItems().stream().map(item -> ItemData.builder()
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .build()).toList();
        return responseData(data);
    }

    @PutMapping("/update/{book-id}")
    public ResponseData<?> updateBook(
            @PathVariable(name = "book-id") Long id,
            @RequestBody Book body
    ) {
        body.setId(id);
        service.saveItem(body);
        return entityToDto(body);
    }

    private ResponseData<?> entityToDto(Book item) {
        var data = ItemData.builder()
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .build();
        return responseData(data);
    }

    private ResponseData<Object> responseData(Object data) {
        return ResponseData.builder()
                .status(200)
                .success(true)
                .message("정상 작동")
                .data(data)
                .build();
    }
}
