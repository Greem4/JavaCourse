package com.greem4.spring.integration.database.repository;

import com.greem4.spring.database.entity.User;
import com.greem4.spring.database.repository.UserRepository;
import com.greem4.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkQueries() {
        var users = userRepository.findAllBy("a", "ov");
        Assertions.assertThat(users).hasSize(3);
    }
}