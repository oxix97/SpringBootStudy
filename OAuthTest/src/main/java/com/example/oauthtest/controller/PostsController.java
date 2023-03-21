package com.example.oauthtest.controller;

import com.example.oauthtest.config.auth.dto.PostsResponseDto;
import com.example.oauthtest.config.auth.dto.PostsSaveRequestDto;
import com.example.oauthtest.config.auth.dto.PostsUpdateRequestDto;
import com.example.oauthtest.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostsController {
    private final PostsService service;

    @PostMapping("/post")
    public Long save(
            @RequestBody PostsSaveRequestDto requestDto
    ) {
        return service.save(requestDto);
    }

    @PutMapping("/put/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto) {
        return service.update(id, requestDto);
    }

    @GetMapping("/get/{id}")
    public PostsResponseDto find(
            @PathVariable Long id
    ) {
        return service.findById(id);
    }
}
