package com.example.searchlist.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResImageSearch {
    private Integer total;

    private String lastBuildDate;

    private Integer display;

    private Integer start;

    private List<ImageItem> items;
}
