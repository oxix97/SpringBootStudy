package com.example.aoptest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    @Pointcut("execution(* com.example.aoptest.controller..*.*(..))")
    private void cut() {

    }

    //annotation에만 로깅
    @Pointcut("@annotation(com.example.aoptest.annotation.Timer)")
    private void enableTimer() {

    }

    //두가지 조건 다 본다는 의미
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch(); //실행 전
        stopWatch.start();
        Object obj = point.proceed();
        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
