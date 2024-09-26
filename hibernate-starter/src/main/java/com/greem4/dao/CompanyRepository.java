package com.greem4.dao;

import com.greem4.entity.Company;
import org.hibernate.SessionFactory;


public class CompanyRepository extends RepositoryBase<Integer, Company> {

    public CompanyRepository(SessionFactory sessionFactory) {
        super(Company.class, sessionFactory);
    }
}
