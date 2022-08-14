package com.shubham.jwtspringapp.models;

import com.shubham.jwtspringapp.constants.Roles;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    String userName;
    String firstName;
    String lastName;
    boolean isActive;
    String password;
    List<GrantedAuthority> roles;

    public UserDetails() {}
    public UserDetails(User user) {
        this.userName = user.userName;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.isActive = user.isActive;
        this.password = user.password;
        this.roles = user.roles.stream()
                .map(Roles::toString)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public UserDetails(CreateUserRequest user) {
        this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.isActive = user.isActive();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
