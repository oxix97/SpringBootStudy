package com.example.interceptorexample.interceptor;

import com.example.interceptorexample.annotation.Auth;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //request, response body를 읽으면 손실이 된다.
        //filter에서 만약 ContentCachingWrapper를 사용하여 doFilter에다가 넣으면
        //interceptor 에서 형변환을 해줄 수 있다.
//        ContentCachingRequestWrapper contentReq = (ContentCachingRequestWrapper) request;
//        ContentCachingResponseWrapper contentRes = (ContentCachingResponseWrapper) response;
        log.info("request url : {}", request.getRequestURI());
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has Annotation : {}", hasAnnotation);

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

//        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has Annotation : {}", hasAnnotation);
        //Auth 권한을 가진 요청에 대해서만 세선,쿠키 등을 검사
        if (hasAnnotation) { //권한 체크
            String query = uri.getQuery();
            log.info("query : {}", query);
            return query.contains("name=Chan");
        }

        //return value -> false : filter -> dispatcher -> interceptor -> 진입 불가.
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }

    private boolean checkAnnotation(Object handler, Class clazz) {
        //resource javascript, html 는 통과 시킨다.
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

//        annotation check
        HandlerMethod method = (HandlerMethod) handler;

        log.info("get annotation : {}", method.getMethodAnnotation(clazz));
        log.info("get bean type : {}", method.getBeanType().getAnnotation(clazz));

        if (method.getMethodAnnotation(clazz) != null ||
                method.getBeanType().getAnnotation(clazz) != null) {
            //Auth annotation 이 있으면 true

            return true;
        }

        return false;
    }
}
