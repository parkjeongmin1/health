package com.health.controller;

import com.health.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/")
    public String main() {
        return "index";
    }
}
