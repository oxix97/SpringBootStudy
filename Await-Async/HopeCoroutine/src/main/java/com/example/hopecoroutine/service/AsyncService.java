package com.example.hopecoroutine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async
    public CompletableFuture run() throws InterruptedException {
        return CompletableFuture.completedFuture(hello());
    }

    public String hello() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            log.info("thread sleep....");
            Thread.sleep(500L);
        }
        log.info("wake up!!");
        return "async hello";
    }
}
