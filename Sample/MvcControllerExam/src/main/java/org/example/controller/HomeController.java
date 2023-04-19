package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.annotation.RequestMapping;
import org.example.repository.UserRepository;

public class HomeController implements Controller {
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("", UserRepository.findAll());
        return "home.jsp";
    }
}
