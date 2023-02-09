package com.example.ioctest.ioc.encode;

import java.util.Base64;

public class Base64Encoder implements EncodingService{
    public String encode(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
}
