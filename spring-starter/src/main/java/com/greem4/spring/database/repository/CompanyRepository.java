package com.greem4.spring.database.repository;

import com.greem4.spring.bpp.InjectBean;
import com.greem4.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    @InjectBean
    private ConnectionPool connectionPool;
}
