package com.shubham.jwtspringapp.controllers;

import com.shubham.jwtspringapp.models.CreateUserRequest;
import com.shubham.jwtspringapp.models.CreateUserResponse;
import com.shubham.jwtspringapp.models.UserDetails;
import com.shubham.jwtspringapp.services.UserDetailsService;
import com.shubham.jwtspringapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class User {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUser(new UserDetails(createUserRequest));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
