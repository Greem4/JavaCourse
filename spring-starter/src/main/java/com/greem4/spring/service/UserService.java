package com.greem4.spring.service;

import com.greem4.spring.database.entity.Company;
import com.greem4.spring.database.repository.CrudRepository;
import com.greem4.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}
