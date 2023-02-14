package com.example.filter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //get method
@Setter // set method
@NoArgsConstructor //default constructor
@AllArgsConstructor // all constructor
public class User {

    private String name;
    private int age;
}
