package com.almameal.api.poc.controller;

import com.almameal.api.poc.model.User;
import com.almameal.api.poc.service.UserService;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
       Iterable<User> users = userService.getAllUsers();
       if(!Iterables.isEmpty(users)){
           return Lists.newArrayList(users);
       }

       return Collections.emptyList();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.createNewUser(newUser);
    }


}
