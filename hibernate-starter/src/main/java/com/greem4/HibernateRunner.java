package com.greem4;

import com.greem4.converter.BirthdayConverter;
import com.greem4.entity.Birthday;
import com.greem4.entity.Role;
import com.greem4.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) throws SQLException {

        Configuration configuration = new Configuration();
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .username("ivan11@gmail.com")
                    .firstname("Ivan")
                    .lastName("Ivanov")
                    .birthday(new Birthday(LocalDate.of(2000, 1, 19)))
                    .role(Role.ADMIN)
                    .build();

            session.save(user);

            session.getTransaction().commit();
        }
    }
}
