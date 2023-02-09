package com.example.ioctest.ioc;

import com.example.ioctest.ioc.encode.Encoder;
import com.example.ioctest.ioc.encode.UrlEncoder;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com";

        //외부에서 Encode
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);

        System.out.println(result);

    }
}
