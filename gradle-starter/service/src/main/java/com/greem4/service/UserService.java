package com.greem4.service;

import com.greem4.dao.UserDao;
import com.greem4.model.User;

import java.util.List;

public class UserService {

    private final UserDao userDao = new UserDao();

    public List<User> getAll() {
        return userDao.findAll();
    }
}
