package com.example.ioctest.ioc.encode;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder {
    private EncodingService service;

    public Encoder(@Qualifier("base64") EncodingService service) {
        this.service = service;
    }

    public void setEncoder(EncodingService service) {
        this.service = service;
    }

    public String encode(String msg) {
        return service.encode(msg);
    }
}
