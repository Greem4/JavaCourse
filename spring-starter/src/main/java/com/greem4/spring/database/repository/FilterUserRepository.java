package com.greem4.spring.database.repository;

import com.greem4.spring.database.entity.User;
import com.greem4.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
