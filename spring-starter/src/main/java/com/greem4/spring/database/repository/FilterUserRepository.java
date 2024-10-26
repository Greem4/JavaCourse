package com.greem4.spring.database.repository;

import com.greem4.spring.database.entity.Role;
import com.greem4.spring.database.entity.User;
import com.greem4.spring.dto.PersonalInfo;
import com.greem4.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
