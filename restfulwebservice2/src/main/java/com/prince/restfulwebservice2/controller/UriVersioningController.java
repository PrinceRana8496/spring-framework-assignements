package com.prince.restfulwebservice2.controller;

import com.prince.restfulwebservice2.model.UserV1;
import com.prince.restfulwebservice2.model.UserV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UriVersioningController {

    @GetMapping("/v1/user")
    public UserV1 getUserV1() {
        return new UserV1(1, "Prince");
    }

    @GetMapping("/v2/user")
    public UserV2 getUserV2() {
        return new UserV2(1, "Prince", "prince@example.com", "9876543210");
    }
}
