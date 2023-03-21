package com.example.oauthtest.config.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
}
