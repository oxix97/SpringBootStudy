package com.example.ioctest.ioc.encode;

public class Base64Encoder implements EncodingService {

    private EncodingService service;

    public String encode(String msg) {
        return service.encode(msg);
    }
}
