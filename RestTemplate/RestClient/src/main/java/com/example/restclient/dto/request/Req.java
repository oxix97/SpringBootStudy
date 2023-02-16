package com.example.restclient.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req<T> {
    private HttpHeaders headers;
    private T responseBody;

//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class Header {
//        private String code;
//    }

}
