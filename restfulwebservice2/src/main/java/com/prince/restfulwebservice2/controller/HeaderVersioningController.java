package com.prince.restfulwebservice2.controller;

import com.prince.restfulwebservice2.model.UserV1;
import com.prince.restfulwebservice2.model.UserV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderVersioningController {

    @GetMapping(value = "/user/header", headers = "X-API-VERSION=1")
    public UserV1 getUserHeaderV1() {
        return new UserV1(3, "Ravi");
    }

    @GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
    public UserV2 getUserHeaderV2() {
        return new UserV2(3, "Ravi", "ravi@example.com", "1122334455");
    }
}

