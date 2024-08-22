package com.greem4.junit.service;

import com.greem4.junit.dto.User;
import org.junit.jupiter.api.*;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

    private static final User IVAN = User.of(1, "Ivan", "123");
    private static final User PETR = User.of(2, "Petr", "111");
    private UserService userService;

    @BeforeAll
    void init() {
        System.out.println("Before all: " + this);
    }

    @BeforeEach
    void prepare() {
        System.out.println("Before each: " + this);
        userService = new UserService();
    }

    @Test
    void usersEmptyIfUserAdded() {
        System.out.println("Test 1: " + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty());
//        input -> [box == func] -> actual output
    }

    @Test
    void userSizeIfUSerAdded() {
        System.out.println("Test 2: " + this);
        userService.add(IVAN);
        userService.add(PETR);

        var users = userService.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void loginSuccessIfUserExists() {
        userService.add(IVAN);

        Optional<User> maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword());

        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals(IVAN, user));
    }

    @Test
    void logicFailIfPasswordIsNotCorrect() {
        userService.add(IVAN);

        var maybeUser = userService.login(IVAN.getUsername(), "111");

        assertTrue(maybeUser.isEmpty());
    }

    @Test
    void logicFailIfUserDoesNotExist() {
        userService.add(IVAN);

        var maybeUser = userService.login("111", IVAN.getPassword());

        assertTrue(maybeUser.isEmpty());
    }


    @AfterEach
    void deleteDataFromDatabase() {
        System.out.println("After each: " + this);
    }

    @AfterAll
    void closeConnectionsPool() {
        System.out.println("After all: " + this);
    }


}
