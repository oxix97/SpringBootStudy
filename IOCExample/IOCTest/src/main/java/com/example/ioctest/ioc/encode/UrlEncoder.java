package com.example.ioctest.ioc.encode;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlEncoder implements EncodingService {

    @Override
    public String encode(String msg) {
        try {
            return URLEncoder.encode(msg, StandardCharsets.UTF_8);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
