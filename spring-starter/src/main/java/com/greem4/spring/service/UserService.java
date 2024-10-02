package com.greem4.spring.service;

import com.greem4.spring.database.entity.Company;
import com.greem4.spring.database.repository.CompanyRepository;
import com.greem4.spring.database.repository.CrudRepository;
import com.greem4.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
