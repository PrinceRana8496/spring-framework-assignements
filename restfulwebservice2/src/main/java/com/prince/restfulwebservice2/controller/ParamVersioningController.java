package com.prince.restfulwebservice2.controller;

import com.prince.restfulwebservice2.model.UserV1;
import com.prince.restfulwebservice2.model.UserV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamVersioningController {

    @GetMapping(value = "/user/param", params = "version=1")
    public UserV1 getUserParamV1() {
        return new UserV1(2, "Aryan");
    }

    @GetMapping(value = "/user/param", params = "version=2")
    public UserV2 getUserParamV2() {
        return new UserV2(2, "Aryan", "aryan@example.com", "1234567890");
    }
}
