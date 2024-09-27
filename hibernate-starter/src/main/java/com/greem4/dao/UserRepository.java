package com.greem4.dao;

import com.greem4.entity.User;

import javax.persistence.EntityManager;


public class UserRepository extends RepositoryBase<Long, User>{

    public UserRepository(EntityManager entityManager) {
        super(User.class, entityManager);
    }

    // TODO
}
