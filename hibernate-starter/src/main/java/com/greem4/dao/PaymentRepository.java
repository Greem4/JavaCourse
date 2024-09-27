package com.greem4.dao;

import com.greem4.entity.Payment;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;


public class PaymentRepository extends RepositoryBase<Long, Payment> {

    public PaymentRepository(EntityManager entityManager) {
        super(Payment.class, entityManager);
    }
}
