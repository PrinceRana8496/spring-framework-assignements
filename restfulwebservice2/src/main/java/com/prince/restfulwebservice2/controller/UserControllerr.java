package com.prince.restfulwebservice2.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.prince.restfulwebservice2.model.User;
import com.prince.restfulwebservice2.model.UserNotFoundException;
import com.prince.restfulwebservice2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management", description = "User-related operations")
public class UserControllerr {

    private final UserService userService;
    public UserControllerr(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        User user = userService.getUserById(id);

        if (user == null) {
            throw new UserNotFoundException("User not found with id: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(201).body("User created successfully");
    }

    @Operation(summary = "Delete a user by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);

        if (deleted) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<Collection<User>> getAllUsers() {
        Collection<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/user")
    public MappingJacksonValue getUserFiltered() {
        User user = new User(1, "Prince", 22, "secret123");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("name", "age");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("UserFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/user/password")
    public MappingJacksonValue getUserWithPassword() {
        User user = new User(2, "Admin", 23, "admin@123");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .serializeAllExcept("password");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("UserFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }
}
