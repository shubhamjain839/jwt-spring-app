package com.shubham.jwtspringapp.controllers;

import com.shubham.jwtspringapp.models.AuthenticationRequest;
import com.shubham.jwtspringapp.models.AuthenticationResponse;
import com.shubham.jwtspringapp.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Authentication {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @PostMapping
    public ResponseEntity<AuthenticationResponse>
    authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName()
                        , authenticationRequest.getPassword()));
        return new ResponseEntity<>(AuthenticationResponse.builder()
                .jwt(jwtUtils.generateToken(authenticationRequest.getUserName()))
                .build(),
                HttpStatus.OK);
    }
}
