package org.example.mvc;

import org.example.controller.Controller;
import org.example.controller.ForwardController;
import org.example.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {
    private Map<String, Controller> map = new HashMap<>();

    void init() {
        map.put("/", new HomeController());
    }

    public Controller findHandler(String path) {
        return map.get(path);
    }
}
