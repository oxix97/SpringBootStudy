package com.example.searchlist.controller;

import com.example.searchlist.dto.WishListDto;
import com.example.searchlist.service.NaverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {

    private final NaverService service;

    @GetMapping("/naver/search")
    public WishListDto naverSearch(@RequestParam String query) {
        return service.search(query);
    }

    @PostMapping("/naver/add")
    public void itemAdd(@RequestBody WishListDto body) {
        service.add(body);
    }

    @PostMapping("/naver/visit/{index}")
    public void addVisit(
            @PathVariable("index") int index
    ) {
        service.addVisited(index);
    }

    @GetMapping("/naver/all")
    public List<WishListDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/naver/delete")
    public void delete(@RequestParam Integer index) {
        service.delete(index);
    }

}
