package com.greem4.spring.integration.service;

import com.greem4.spring.database.pool.ConnectionPool;
import com.greem4.spring.integration.annotation.IT;
import com.greem4.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void test() {
        System.out.println();
    }

    @Test
    void test2() {
        System.out.println();
    }
}