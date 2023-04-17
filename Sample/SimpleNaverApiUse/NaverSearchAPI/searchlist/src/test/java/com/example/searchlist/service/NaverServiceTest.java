package com.example.searchlist.service;

import com.example.searchlist.dto.WishListDto;
import com.example.searchlist.wishlist.WishListRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class NaverServiceTest {
    @Autowired
    private NaverService service;

    @Autowired
    @MockBean
    private WishListRepository repository;

    @Test
    public void searchTest() {
        var result = service.search("갈비집");
        System.out.println(result);
        Assertions.assertNotNull(result);
    }

    @Test
    public void addTest() {
        var dto = new WishListDto();
        dto.setTitle("alksdfjjalksdfjklfsd");
        service.add(dto);
        System.err.println(service.findAll().size());
        System.out.println(repository.listAll().size());
    }
}
