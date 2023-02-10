package com.example.aoptest.aop;

import com.example.aoptest.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Aspect
@Component
public class DecodeAop {
    @Pointcut("execution(* com.example.aoptest.controller..*.*(..))")
    private void cut() {

    }

    //annotation에만 로깅
    @Pointcut("@annotation(com.example.aoptest.annotation.Decode)")
    private void enableDecode() {

    }

    //전 -> decode 해서 값 들어감
    //후 -> encode 해서 반환
    @Before("cut() && enableDecode()")
    public void before(JoinPoint point) {
        //내가 원하는 argment를 찾아서 변환해야 한다. -> 특정 객체,변수
        Object[] args = point.getArgs();

        for (Object obj : args) {
            if (obj instanceof User user) {
                //내가 원하는 객체 찾음 -> User 객체로 형변환 -> email
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email));
                user.setEmail(email);
                System.out.println("before method : "+email);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "object")
    public void afterReturn(JoinPoint point, Object object) {
        if (object instanceof User user) {
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base64Email);
            System.out.println("after method : "+base64Email);
        }
    }
}
