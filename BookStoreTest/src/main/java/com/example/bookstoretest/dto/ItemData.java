package com.example.bookstoretest.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ItemData {
    private String name;
    private int price;
    private int stockQuantity;
}
