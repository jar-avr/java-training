package com.training.dto;

import com.training.entity.User;

import java.util.List;

public class UsersWrapper {
    List<User> users;

    public UsersWrapper(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
