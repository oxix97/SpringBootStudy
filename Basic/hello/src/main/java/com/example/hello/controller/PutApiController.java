package com.example.hello.controller;

import com.example.hello.dto.ParkingInfoReq;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/put-test")
public class PutApiController {

    @PutMapping("/test")
    public void putTest(@RequestBody String str) {
        System.out.println(str);
    }

    @PutMapping("/parking-info")
    public ParkingInfoReq updateParkingInfo(@RequestBody ParkingInfoReq request) {
        return request;
    }
}
