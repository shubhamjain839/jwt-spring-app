package com.shubham.jwtspringapp.models;

import com.shubham.jwtspringapp.constants.Roles;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Document
public class User {
    public  User() {}
    public User(UserDetails userDetails) {
        userName = userDetails.userName;
        password = userDetails.password;
        firstName = userDetails.firstName;
        lastName = userDetails.lastName;
        isActive = userDetails.isActive;
        roles = userDetails.roles.stream()
                .map(GrantedAuthority::getAuthority)
                .map(Roles::valueOf)
                .collect(Collectors.toList());
    }
    @MongoId
    String id;

    @Field("user_name")
    String userName;

    @Field("first_name")
    String firstName;

    @Field("last_name")
    String lastName;

    @Field("is_active")
    boolean isActive;

    @Field("password")
    String password;

    @Field("roles")
    List<Roles> roles;
}
