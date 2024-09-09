package com.greem4.junit.service;

import com.greem4.junit.dto.User;
import com.greem4.junit.extension.GlobalExtension;
import com.greem4.junit.extension.UserServiceParamResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("fast")
@Tag("user")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith({
        UserServiceParamResolver.class,
        GlobalExtension.class
})
public class UserServiceTest {

    private static final User IVAN = User.of(1, "Ivan", "123");
    private static final User PETR = User.of(2, "Petr", "111");

    private UserService userService;

    UserServiceTest(TestInfo testInfo) {
        System.out.println();
    }

    @BeforeAll
    void init() {
        System.out.println("Before all: " + this);
    }

    @BeforeEach
    void prepare(UserService userService) {
        System.out.println("Before each: " + this);
        this.userService = userService;
    }

    @Test
    @Order(1)
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

        assertThat(users).hasSize(2);
//        assertEquals(2, users.size());
    }

    @Test
    void usersConvertedToMapById() {
        userService.add(IVAN, PETR);

        Map<Integer, User> users = userService.getAllConvertedById();

        assertAll(
                () -> assertThat(users).containsKeys(IVAN.getId(), PETR.getId()),
                () -> assertThat(users).containsKeys(IVAN.getId(), PETR.getId())
        );

    }

    @AfterEach
    void deleteDataFromDatabase() {
        System.out.println("After each: " + this);
    }

    @AfterAll
    void closeConnectionsPool() {
        System.out.println("After all: " + this);
    }

    @Nested
    @DisplayName("test user login functionality")
    @Tag("login")
    @Timeout(value = 350, unit = TimeUnit.MILLISECONDS)
    class LoginTest {

        @Test
        @Disabled("flaky, need to see")
        void loginFailIfPasswordIsNotCorrect() {
            userService.add(IVAN);

            var maybeUser = userService.login(IVAN.getUsername(), "111");

            assertTrue(maybeUser.isEmpty());
        }

        //        @Test
        @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
        void loginFailIfUserDoesNotExist(RepetitionInfo repetitionInfo) {
            userService.add(IVAN);

            var maybeUser = userService.login("111", IVAN.getPassword());

            assertTrue(maybeUser.isEmpty());
        }

        @Test
        void checkLoginFunctionalityPerformance() {
            System.out.println(Thread.currentThread().getName());
            var result = assertTimeoutPreemptively(Duration.ofMillis(350), () -> {
                Thread.sleep(300);
                System.out.println(Thread.currentThread().getName());
                return userService.login("dumy", IVAN.getPassword());
            });
        }

        @Test
        void loginSuccessIfUserExists() {
            userService.add(IVAN);

            Optional<User> maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword());

            assertThat(maybeUser).isPresent();
            maybeUser.ifPresent(user -> assertThat(user).isEqualTo(IVAN));

//        assertTrue(maybeUser.isPresent());
//        maybeUser.ifPresent(user -> assertEquals(IVAN, user));
        }

        @Test
        void throwExceptionIfUserNameOrPasswordIsNull() {
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> userService.login(null, "123")),
                    () -> assertThrows(IllegalArgumentException.class, () -> userService.login("Ivan", null))
            );
        }

        @ParameterizedTest(name = "{arguments} test")
//        @ArgumentsSource()
//        @NullSource
//        @EmptySource
//        @NullAndEmptySource
//        @ValueSource(strings = {
//                "Ivan", "Petr"
//        })
//        @EnumSource()
        @MethodSource("com.greem4.junit.service.UserServiceTest#getArgumentsForLoginTest")
//        @CsvFileSource(resources = "/login-test-data.csv", delimiter = ',', numLinesToSkip = 1)
        @DisplayName("login param test")
        void loginParameterizedTest(String username, String password, Optional<User> user) {
            userService.add(IVAN, PETR);

            var maybeUser = userService.login(username, password);
            assertThat(maybeUser).isEqualTo(user);
        }
    }

    static Stream<Arguments> getArgumentsForLoginTest() {
        return Stream.of(
                Arguments.of("Ivan", "123", Optional.of(IVAN)),
                Arguments.of("Petr", "111", Optional.of(PETR)),
                Arguments.of("Petr", "dump", Optional.empty()),
                Arguments.of("dump", "123", Optional.empty())
        );
    }
}
