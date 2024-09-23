package com.greem4;

import com.greem4.entity.Payment;
import com.greem4.entity.Profile;
import com.greem4.entity.User;
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
import java.util.List;


@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            TestDataImporter.importData(sessionFactory);
//            session.doWork(connection -> connection.setAutoCommit(false));

//            session.beginTransaction();

            var profile = Profile.builder()
                    .user(session.find(User.class, 1L))
                    .language("ru")
                    .street("Kolasa 28")
                    .build();
            session.save(profile);

            var payments = session.createQuery("select p from Payment p", Payment.class)
//                    .setLockMode(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
//                    .setHint("javax.persistence.lock.timeout", 5000)
//                    .setReadOnly(true)
                    .list();

            var payment = session.find(Payment.class, 1L);
            payment.setAmount(payment.getAmount() + 10);

//            session.getTransaction().commit();
        }
    }
}
