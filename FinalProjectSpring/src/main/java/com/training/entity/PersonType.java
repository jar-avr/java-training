package com.training.entity;

public enum PersonType {
    NATURAL,
    LEGAL;

    public String getType() {
        return name();
    }
}
