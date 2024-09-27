package com.greem4.dto;

import com.greem4.entity.PersonalInfo;
import com.greem4.entity.Role;
import com.greem4.validation.UpdateCheck;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record UserCreateDto(
        @Valid
        PersonalInfo personalInfo,
        @NotNull
        String username,
        String info,
        @NotNull(groups = UpdateCheck.class)
        Role role,
        Integer companyId) {
}
