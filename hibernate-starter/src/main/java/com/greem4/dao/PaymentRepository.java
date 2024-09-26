package com.greem4.dao;

import com.greem4.entity.Payment;
import org.hibernate.SessionFactory;


public class PaymentRepository extends RepositoryBase<Long, Payment> {

    public PaymentRepository(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
