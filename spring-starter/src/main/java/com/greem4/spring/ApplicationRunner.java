package com.greem4.spring;

import com.greem4.spring.database.pool.ConnectionPool;
import com.greem4.spring.database.repository.CompanyRepository;
import com.greem4.spring.database.repository.UserRepository;
import com.greem4.spring.ioc.Container;
import com.greem4.spring.service.UserService;

public class ApplicationRunner {

    public static void main(String[] args) {
        var container = new Container();


//        var connectionPool = new ConnectionPool();
//        var userRepository = new UserRepository(connectionPool);
//        var companyRepository = new CompanyRepository(connectionPool);
//        var userService = new UserService(userRepository, companyRepository);

//        var connectionPool = container.get(ConnectionPool.class);
//        var userRepository =  container.get(UserRepository.class);
//        var companyRepository =  container.get(CompanyRepository.class);
        var userService =  container.get(UserService.class);
        // TODO: 28.09.2024 userService
    }
}
