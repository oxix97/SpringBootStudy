package com.example.ioctest.ioc;

import com.example.ioctest.ioc.encode.Base64Encoder;
import com.example.ioctest.ioc.encode.Encoder;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com";


        //외부에서 Encode
        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);

        System.out.println(result);

    }
}
