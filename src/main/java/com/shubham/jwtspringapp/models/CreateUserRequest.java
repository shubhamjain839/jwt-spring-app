package com.shubham.jwtspringapp.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CreateUserRequest {

    String userName;
    String firstName;
    String lastName;
    boolean isActive;
    String password;
    List<String> roles;
}
