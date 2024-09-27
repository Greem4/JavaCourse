package com.greem4.service;

import com.greem4.dao.UserRepository;
import com.greem4.dto.UserCreateDto;
import com.greem4.dto.UserReadDto;
import com.greem4.entity.User;
import com.greem4.mapper.Mapper;
import com.greem4.mapper.UserCreateMapper;
import com.greem4.mapper.UserReadMapper;
import com.greem4.validation.UpdateCheck;
import lombok.RequiredArgsConstructor;
import org.hibernate.graph.GraphSemantic;

import javax.transaction.Transactional;
import javax.validation.*;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateMapper userCreateMapper;

    @Transactional
    public Long create(UserCreateDto userDto) {
        // validation
        var validatorFactory = Validation.buildDefaultValidatorFactory();
        var validator = validatorFactory.getValidator();
        var validationResult = validator.validate(userDto, UpdateCheck.class);
        if (!validationResult.isEmpty()) {
            throw new ConstraintViolationException(validationResult);
        }

        var userEntity = userCreateMapper.mapFrom(userDto);
        return userRepository.save(userEntity).getId();
    }

    @Transactional
    public Optional<UserReadDto> findById(Long id) {
        return findById(id, userReadMapper);
    }

    @Transactional
    public <T> Optional<T> findById(Long id, Mapper<User, T> mapper) {
        Map<String, Object> properties = Map.of(
                GraphSemantic.LOAD.getJpaHintName(), userRepository.getEntityManager().getEntityGraph("WithCompany")
        );
        return userRepository.findById(id, properties)
                .map(mapper::mapFrom);
    }

    @Transactional
    public boolean delete(Long id) {
        var maybeUser = userRepository.findById(id);
        maybeUser.ifPresent(user -> userRepository.delete(user.getId()));
        return maybeUser.isPresent();
    }
}
