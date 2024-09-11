package com.greem4;

import com.greem4.entity.User;
import com.greem4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;


public class HibernateRunner {

    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) throws SQLException {
        User user = User.builder()
                .username("ivanov@mail.com")
                .lastname("Ivanov")
                .firstname("Ivan")
                .build();
        log.info("User entity is in transient state, object: {}", user);
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();
                log.trace("Transaction is created, {}", transaction);

                session1.saveOrUpdate(user);
                log.trace("User is in persistent state: {} session1: {}", user, session1);

                session1.getTransaction().commit();
            }
            log.warn("User is im detached state: {}, session is closed {}", user, session1);
        }catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            throw exception;
        }
    }
}
