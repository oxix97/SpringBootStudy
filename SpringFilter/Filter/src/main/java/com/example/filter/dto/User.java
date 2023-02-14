package com.example.filter.dto;

import lombok.*;


@Data //getter + setter + toString
@NoArgsConstructor //default constructor
@AllArgsConstructor // all constructor

public class User {
    private String name;
    private String email;
    private int age;
}
