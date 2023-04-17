package com.example.searchlist.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResLocalSearch {
    private Integer total;

    private String lastBuildDate;

    private Integer display;

    private Integer start;

    private List<Item> items;

    @Data
    public static class Item {
        private String title;
        private String link;
        private String category;
        private String description;
        private String telephone;
        private String address;
        private String roadAddress;
        private String mapy;
        private String mapx;
    }
}
