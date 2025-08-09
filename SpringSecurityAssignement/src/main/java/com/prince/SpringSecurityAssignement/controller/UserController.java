package com.prince.SpringSecurityAssignement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/admin")
    public String adminAccess() {
        return "Hello Admin!";
    }

    @GetMapping("/user")
    public String userAccess() {
        return "Hello User!";
    }
}
