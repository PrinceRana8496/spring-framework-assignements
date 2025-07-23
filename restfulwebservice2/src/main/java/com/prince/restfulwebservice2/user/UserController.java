package com.prince.restfulwebservice2.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final List<Users> users=new ArrayList<>();
    //@PostMapping(value = "/user",consumes = MediaType.APPLICATION_XML_VALUE)
    @PostMapping(value = "/user")
    public String createUser(@RequestBody Users user)
    {
        users.add(user);
        return user.getName();
    }
    @GetMapping("/user")
    public List<Users> getUsers()
    {
        return users;
    }
}
