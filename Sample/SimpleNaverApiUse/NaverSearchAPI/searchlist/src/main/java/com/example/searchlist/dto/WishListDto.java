package com.example.searchlist.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WishListDto {
    private Integer index;
    private String title;
    private String category;
    private String address;
    private String readAddress;
    private String homePageLink;
    private String imgLink;
    private boolean isVisited;
    private int visitCount;
    private LocalDateTime lastVisitDate;
}
