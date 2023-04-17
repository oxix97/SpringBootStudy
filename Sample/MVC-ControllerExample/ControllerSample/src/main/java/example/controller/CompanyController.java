package example.controller;

import example.annotation.Controller;
import example.annotation.RequestMapping;
import example.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CompanyController {
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "company";
    }
}
