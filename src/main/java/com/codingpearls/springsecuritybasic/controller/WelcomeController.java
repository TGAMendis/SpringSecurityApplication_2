package com.codingpearls.springsecuritybasic.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String sayWelcome(Authentication authentication) {
        return "Welcome " + authentication.getName() + "! This is a secure endpoint.";
    }

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello! This is a public endpoint.";
    }
}