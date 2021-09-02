package ru.javavision.entity;

public enum Role {
    PERSON,
    INSPECTOR,
    ADMIN;

    public String getAuthority() {
        return "ROLE_" + name();
    }
}
