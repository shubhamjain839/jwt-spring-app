package com.shubham.jwtspringapp.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationRequest {
    String userName;
    String password;
}
