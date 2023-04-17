package com.example.naverapiexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NaverData implements Serializable {
    private Integer total;

    private String lastBuildDate;

    private Integer display;

    private Integer start;

    private List<Item> items;
}
