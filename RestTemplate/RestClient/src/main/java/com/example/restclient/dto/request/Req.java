package com.example.restclient.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req<T> {
    private Header header;
    private T responseBody;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {
        private String code;
    }

}
