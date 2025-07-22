package com.prince.spring_rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/welcome")
    public String getData()
    {
        return "Welcome to Spring Boot";
    }
}
