package com.greem4.spring.dto;

import com.greem4.spring.database.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {
    String username;
    LocalDate birthday;
    String firstName;
    String lastName;
    Role role;
    Integer companyId;
}
