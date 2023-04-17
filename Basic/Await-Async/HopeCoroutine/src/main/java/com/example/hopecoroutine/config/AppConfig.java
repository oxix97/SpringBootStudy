package com.example.hopecoroutine.config;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;

@Configuration
public class AppConfig {

    //중요함
    // MaxPoolSize, CorePoolSize, QueueCapacity 는 동작하는 방식이 어느정도 정해져있다.
    // PoolSize를 모두 사용하는 경우 -> Queue에 내용이 들어간다.
    // Queue에 있는 것도 모두 사용하면 pool 사이즈가 지정한 만큼 늘어난다.
    // 해당 루틴이 반복되어 max값까지 늘어난다.
    @Bean("async-thread")
    public Executor asyncThread() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(100);
        executor.setCorePoolSize(10);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("Async");
        return executor;
    }
}
