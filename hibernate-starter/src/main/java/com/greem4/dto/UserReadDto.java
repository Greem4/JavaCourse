package com.greem4.dto;

import com.greem4.entity.PersonalInfo;
import com.greem4.entity.Role;

public record UserReadDto(Long id,
                          PersonalInfo personalInfo,
                          String username,
                          String info,
                          Role role,
                          CompanyReadDto company) {
}
