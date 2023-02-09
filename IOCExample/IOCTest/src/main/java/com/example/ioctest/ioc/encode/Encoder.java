package com.example.ioctest.ioc.encode;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Encoder {

    private EncodingService service;

    public Encoder(EncodingService service) {
        this.service = service;
    }

    public void setEncodingService(EncodingService EncodingService) {
        this.service = EncodingService;
    }

    public String encode(String message) {
        return service.encode(message);
    }
}