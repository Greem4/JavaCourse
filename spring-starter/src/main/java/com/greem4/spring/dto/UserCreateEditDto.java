package com.greem4.spring.dto;

import com.greem4.spring.database.entity.Role;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @NotNull
    @Size(min = 2, max = 64)
    String firstname;

    @NotNull
    String lastname;

    Role role;

    Integer companyId;
}
