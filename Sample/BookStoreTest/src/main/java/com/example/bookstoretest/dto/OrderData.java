package com.example.bookstoretest.dto;

import com.example.bookstoretest.entity.Address;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class OrderData {
    private String memberName;
    private List<String> items;
    private Address address;
    private int totalPrice;
    private int count;
}
