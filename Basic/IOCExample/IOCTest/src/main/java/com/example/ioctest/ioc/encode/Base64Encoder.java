package com.example.ioctest.ioc.encode;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base74Encoder") // -> Spring 에서 bin으로 바꾼다음 관리권한을 Spring에게 관리 권한 위임
public class Base64Encoder implements EncodingService {

    @Override
    public String encode(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
}
