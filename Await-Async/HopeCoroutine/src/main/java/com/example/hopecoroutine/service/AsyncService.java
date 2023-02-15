package com.example.hopecoroutine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

    @Async
    public void hello() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            log.info("thread sleep....");
            Thread.sleep(500L);
        }
        log.info("wake up!!");
    }
}
