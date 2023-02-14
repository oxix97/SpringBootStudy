package com.example.filter.filter;

import com.example.filter.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class GlobalFilter implements Filter {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //길이만 초기화 , 전처리과정 내용을 담고 있지는 않다.
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        //doFilter 를 통해 실제 Spring 내부로 들어가야 content 담긴다.
        //후처리는 항상 doFilter 이후에 처리 해야한다.

        String url = httpServletRequest.getRequestURI();
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, requestBody : {}", url, reqContent);

        chain.doFilter(httpServletRequest, httpServletResponse);

        User user = new User("After", "user@naver.com", 123123);
        String stringUser = mapper.writeValueAsString(user);
        httpServletResponse.reset();
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(stringUser);

        String resContent = new String(httpServletResponse.getContentAsByteArray());

        int httpStatusCode = httpServletResponse.getStatus();
        log.info("response status : {}, responseBody : {}", httpStatusCode, resContent);

        //ContentAsByte를 써서 리턴할 값을 다 뺀 상태이기 때문에 복사하여 반환해주어야한다.
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
