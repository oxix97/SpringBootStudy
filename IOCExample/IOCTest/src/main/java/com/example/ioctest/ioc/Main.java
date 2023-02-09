package com.example.ioctest.ioc;

import com.example.ioctest.ioc.encode.Encoder;
import com.example.ioctest.ioc.encode.UrlEncoder;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com";

        //todo 외부에서 내가 사용하는 객체를 주입하는 것 -> DI
//        Encoder encode = new Encoder(new Base64Encoder());
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);

        System.out.println(result);

    }
}
