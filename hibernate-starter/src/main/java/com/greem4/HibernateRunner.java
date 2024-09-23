package com.greem4;

import com.greem4.entity.Payment;
import com.greem4.util.HibernateUtil;
import com.greem4.util.TestDataImporter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.SQLException;


@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Session session1 = sessionFactory.openSession();
            TestDataImporter.importData(sessionFactory);

            session.beginTransaction();
            session1.beginTransaction();

            var payment = session.find(Payment.class, 1L, LockModeType.OPTIMISTIC);
            payment.setAmount(payment.getAmount() + 10);

            var theSamePayment = session1.find(Payment.class, 1L, LockModeType.OPTIMISTIC);
            theSamePayment.setAmount(theSamePayment.getAmount() + 20);

            session.getTransaction().commit();
            session1.getTransaction().commit();
        }
    }
}
