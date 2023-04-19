package org.example.mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private RequestMappingHandlerMapping mapper;

    @Override
    public void init() throws ServletException {
        mapper = new RequestMappingHandlerMapping();
        mapper.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started");
        try {
            Controller handler = mapper.findHandler(req.getRequestURI());
            String name = handler.handleRequest(req, resp);
            log.info("name : {}",name);
            RequestDispatcher dispatcher = req.getRequestDispatcher(name);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            log.error("exception message : {}", e.getMessage());
        }
    }
}
