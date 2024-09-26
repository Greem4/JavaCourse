package com.greem4;

import com.greem4.entity.Payment;
import com.greem4.interceptor.GlobalInterceptor;
import com.greem4.util.HibernateUtil;
import com.greem4.util.TestDataImporter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Date;


@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
//            TestDataImporter.importData(sessionFactory);
            try (var session1 = sessionFactory.openSession()) {
                session1.beginTransaction();

                var payment = session1.find(Payment.class, 1L);
                payment.setAmount(payment.getAmount() + 10);

                session1.getTransaction().commit();
            }
            try (var session2 = sessionFactory.openSession()) {
                session2.beginTransaction();

                var auditReader = AuditReaderFactory.get(session2);
                var oldPayment = auditReader.find(Payment.class, 1L, new Date(1727292800491L));
                session2.replicate(oldPayment, ReplicationMode.OVERWRITE);

                auditReader.createQuery()
                        .forEntitiesAtRevision(Payment.class, 400l)
                        .add(AuditEntity.property("amount").ge(450))
                        .add(AuditEntity.property("id").ge(6l))
                        .addProjection(AuditEntity.property("amount"))
                        .addProjection(AuditEntity.id())
                        .getResultList();

                session2.getTransaction().commit();
            }
        }
    }
}
