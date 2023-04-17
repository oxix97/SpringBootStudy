package com.example.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/*")
public class TempFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //길이만 초기화 , 전처리과정 내용을 담고 있지는 않다.
        ContentCachingRequestWrapper httpServletRequest =
                new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        //doFilter 를 통해 실제 Spring 내부로 들어가야 content 담긴다.
        //후처리는 항상 doFilter 이후에 처리 해야한다.
        String url = httpServletRequest.getRequestURI();
        String reqContent = new String(httpServletRequest.getContentAsByteArray());

        log.info("request url : {}, requestBody : {}", url, reqContent);
        chain.doFilter(httpServletRequest, httpServletResponse);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatusCode = httpServletResponse.getStatus();
        log.info("response status : {}, responseBody : {}", httpStatusCode, resContent);

        httpServletResponse.copyBodyToResponse();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("init filter {}", filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("destroy filter");
    }
}
