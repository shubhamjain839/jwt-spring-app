package com.shubham.jwtspringapp.services;

import com.shubham.jwtspringapp.models.User;
import com.shubham.jwtspringapp.models.UserDetails;
import com.shubham.jwtspringapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public void createUser(UserDetails userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userRepository.save(new User(userDetails));
    }
}
