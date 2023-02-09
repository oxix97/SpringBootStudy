package com.example.ioctest.ioc;

import com.example.ioctest.ioc.encode.Base64Encoder;
import com.example.ioctest.ioc.encode.EncodingService;
import com.example.ioctest.ioc.encode.UrlEncoder;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com";

        EncodingService base64Encoder = new Base64Encoder();
        String base64Result = base64Encoder.encode(url);

        EncodingService urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);
    }
}
