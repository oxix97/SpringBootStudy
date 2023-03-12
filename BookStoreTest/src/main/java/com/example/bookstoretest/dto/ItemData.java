package com.example.bookstoretest.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ItemData extends BaseData<ItemData> {
    private String name;
    private int price;
    private int stockQuantity;
}
