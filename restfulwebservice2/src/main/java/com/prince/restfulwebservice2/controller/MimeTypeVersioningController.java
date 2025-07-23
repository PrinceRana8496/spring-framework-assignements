package com.prince.restfulwebservice2.controller;

import com.prince.restfulwebservice2.model.UserV1;
import com.prince.restfulwebservice2.model.UserV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MimeTypeVersioningController {

    @GetMapping(value = "/user/produces", produces = "application/vnd.company.app-v1+json")
    public UserV1 getUserMimeV1() {
        return new UserV1(4, "Amit");
    }

    @GetMapping(value = "/user/produces", produces = "application/vnd.company.app-v2+json")
    public UserV2 getUserMimeV2() {
        return new UserV2(4, "Amit", "amit@example.com", "5566778899");
    }
}
