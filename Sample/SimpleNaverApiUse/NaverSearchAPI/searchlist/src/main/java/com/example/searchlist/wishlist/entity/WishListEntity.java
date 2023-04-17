package com.example.searchlist.wishlist.entity;

import com.example.searchlist.db.entity.MemoryEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WishListEntity extends MemoryEntity {
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
