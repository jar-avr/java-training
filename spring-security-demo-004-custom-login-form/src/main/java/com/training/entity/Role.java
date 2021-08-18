package com.training.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    PERSON,
    INSPECTOR,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
