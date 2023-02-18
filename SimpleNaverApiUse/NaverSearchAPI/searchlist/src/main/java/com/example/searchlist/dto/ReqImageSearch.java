package com.example.searchlist.dto;

import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
public class ReqImageSearch {
    private String query = "";
    private int display = 1;
    private int start = 1;
    private String sort = "random";
    private String filter = "all";

    public MultiValueMap<String, String> toMultiValueMap() {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);
        map.add("filter", filter);
        return map;
    }
}
