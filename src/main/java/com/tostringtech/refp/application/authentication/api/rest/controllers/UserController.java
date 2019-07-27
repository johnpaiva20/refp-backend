package com.tostringtech.refp.application.authentication.api.rest.controllers;

import com.tostringtech.refp.application.authentication.core.models.User;
import com.tostringtech.refp.application.authentication.core.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "Users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User model) {

        User user = userService.createUser(model);

        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> listUsers() {

        List<User> users = new ArrayList<>();

        return new ResponseEntity<>(users, HttpStatus.CREATED);

    }
}
