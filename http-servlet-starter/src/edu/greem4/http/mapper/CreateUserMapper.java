package edu.greem4.http.mapper;

import edu.greem4.http.dto.CreateUserDto;
import edu.greem4.http.entity.Gender;
import edu.greem4.http.entity.Role;
import edu.greem4.http.entity.User;
import edu.greem4.http.util.LocalDateFormater;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormater.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
