package com.example.ioctest.ioc;

import com.example.ioctest.ioc.encode.Encoder;
import com.example.ioctest.ioc.encode.UrlEncoder;

import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "www.naver.com";

        // base 64 encoding
        Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println(result);

        //url encoding
        UrlEncoder urlEncoder = new UrlEncoder();
        String urlResult = UrlEncoder.encode(url);
        System.out.println(urlResult);
    }
}
