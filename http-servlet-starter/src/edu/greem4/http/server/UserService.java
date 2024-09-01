package edu.greem4.http.server;

import edu.greem4.http.dao.UserDao;
import edu.greem4.http.dto.CreateUserDto;
import edu.greem4.http.exception.ValidationException;
import edu.greem4.http.mapper.CreateUserMapper;
import edu.greem4.http.service.ImageService;
import edu.greem4.http.validator.CreateUserValidator;
import lombok.SneakyThrows;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        userDao.save(userEntity);

        return userEntity.getId();
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}
