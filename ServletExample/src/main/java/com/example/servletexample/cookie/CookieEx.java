package com.example.servletexample.cookie;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/api/company")
public class CookieEx extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Creating a cookie
        Cookie cookie = new Cookie("username", "Chan");

        // Adding cookie to the response
        response.addCookie(cookie);

        // Retrieving cookie from the request
        Cookie[] cookies = request.getCookies();

        // Printing cookie value
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    System.out.println(c.getValue());
                }
            }
        }
    }
}
