package com.greem4.dao;

import com.greem4.model.User;

import java.util.List;

public class UserDao {

    public List<User> findAll() {
        return List.of(
                new User(13, "Ivon"),
                new User(23, "Petr"),
                new User(33, "Sveta")
        );
    }
}
