package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String showLogin() {
        return "login/sign_in";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "login/sign_up";
    }
}
