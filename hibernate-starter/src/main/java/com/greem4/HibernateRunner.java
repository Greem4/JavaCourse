package com.greem4;

import com.greem4.dao.PaymentRepository;
import com.greem4.entity.Payment;
import com.greem4.entity.User;
import com.greem4.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;


@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session = sessionFactory.openSession()) {
                session.beginTransaction();

                var paymentRepository = new PaymentRepository(sessionFactory);

                paymentRepository.findById(1L).ifPresent(System.out::println);

                session.getTransaction().commit();
            }
        }
    }
}
