package com.example.bookstoretest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
