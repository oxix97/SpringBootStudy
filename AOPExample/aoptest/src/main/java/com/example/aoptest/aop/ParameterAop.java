package com.example.aoptest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAop {
    //pointcut에는 많은 연산이 있다고 하니 따로 찾아야 겠다.

    // controller 패키지 하위는 다 pointcut에 해당하는 문구
    @Pointcut("execution(* com.example.aoptest.controller..*.*(..))")
    private void cut() {

    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

//        joinPoint.getTarget()

        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return obj : " + returnObj);
    }

}
