package com.greem4;

import com.greem4.entity.User;
import com.greem4.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.sql.SQLException;


@Slf4j
public class HibernateRunner {

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
