package com.greem4;

import com.greem4.entity.Payment;
import com.greem4.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.SQLException;


@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.doWork(connection -> {
                System.out.println(connection.getTransactionIsolation());
            });
//            try {
//                var transaction = session.beginTransaction();
//
//                var payment1 = session.find(Payment.class, 1L);
//                var payment2 = session.find(Payment.class, 2L);
//
//                session.getTransaction().commit();
//            }catch (Exception e) {
//                session.getTransaction().rollback();
//                throw e;
//            }
        }
    }
}
