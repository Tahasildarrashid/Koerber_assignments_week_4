package com.example.client1.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${app.name}")
    private String result;

    @GetMapping("/hello")
    public String hello() {
        return "hello " + result;
    }
}
