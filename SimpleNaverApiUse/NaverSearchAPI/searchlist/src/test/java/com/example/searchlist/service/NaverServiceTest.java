package com.example.searchlist.service;

import com.example.searchlist.dto.ReqImageSearch;
import com.example.searchlist.dto.ReqLocalSearch;
import com.example.searchlist.service.base.BaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class NaverServiceTest {

    @Autowired
    private NaverService service;

    @Test
    public void localSearchTest() {
        var search = new ReqLocalSearch();
        search.setQuery("갈비집");

        var result = service.searchLocal(search);
        System.out.println(result);
    }

    @Test
    public void imageSearchTest() {
        var search = new ReqImageSearch();
        search.setQuery("갈비집");

        var result = service.searchImage(search);
        System.out.println(result);
    }
}
