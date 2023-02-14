package com.example.filter.dto;

import lombok.*;

//@Getter //get method
//@Setter // set method
@Data //getter + setter + toString
@NoArgsConstructor //default constructor
@AllArgsConstructor // all constructor
public class User {
    private String name;
    private int age;
}
