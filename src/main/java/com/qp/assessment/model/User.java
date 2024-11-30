package com.qp.assessment.model;
import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    private Long id;
    private String username;
    private String password;
    private String role; 

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return authorities (roles) here
        return List.of(() -> role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; 
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Implement if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Implement if needed
    }

    @Override
    public boolean isEnabled() {
        return true;  // Implement if needed
    }
}
