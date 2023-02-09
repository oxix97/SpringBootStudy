package com.example.ioctest.ioc.encode;

public class Encoder {
    private EncodingService service;

    public Encoder(EncodingService service) {
        this.service = service;
    }

    public String encode(String msg) {
        return service.encode(msg);
    }
}
