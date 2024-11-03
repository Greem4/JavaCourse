package com.greem4.spring.dto;

import com.greem4.spring.database.entity.Role;
import com.greem4.spring.validation.UserInfo;
import com.greem4.spring.validation.group.CreateAction;
import com.greem4.spring.validation.group.UpdateAction;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo(groups = UpdateAction.class)
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @Size(min = 2, max = 64)
    String firstname;

    String lastname;

    Role role;

    Integer companyId;
}
