package com.example.bookreview.domain.repository.dto;

import lombok.Data;

@Data
public class BookStatus {
    private int code;
    private String description;

    public BookStatus(int code) {
        this.code = code;
        this.description = parseDescription(code);
    }

    public boolean isDisplayed() {
        return this.code == 200;
    }

    private String parseDescription(int code) {
        return switch (code) {
            case 100 -> "판매 종료";
            case 200 -> "판매중";
            case 300 -> "판매 보류";
            default -> "미지원";
        };
    }
}
