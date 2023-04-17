package com.example.servletexample.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/home/*")
//@Component
public class FilterEx implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        log.info("전처리");
        chain.doFilter(req, res);
        log.info("후처리");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

