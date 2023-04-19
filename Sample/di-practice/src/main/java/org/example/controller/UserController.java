package org.example.controller;

import org.example.annotation.Controller;
import org.example.annotation.Inject;
import org.example.service.UserService;

@Controller
public class UserController {

    private final UserService service;

    @Inject
    public UserController(UserService service) {
        this.service = service;
    }

    public UserService getService() {
        return service;
    }
}
