package com.greem4;


import com.greem4.entity.*;
import com.greem4.util.HibernateUtil;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

import static java.util.stream.Collectors.*;

class HibernateRunnerTest {

    @Test
    void localeInfo() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var company = session.get(Company.class, 1);
//            company.getLocales().add(LocaleInfo.of("ru", "Описание на русском"));
//            company.getLocales().add(LocaleInfo.of("en", "English description"));
            company.getUsers().forEach(System.out::println);
            session.getTransaction().commit();
        }
    }

    @Test
    void checkManyToMany() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var user = session.get(User.class, 13L);
            var chat = session.get(Chat.class, 1L);

            var userChat = UserChat.builder()
                    .createdAt(Instant.now())
                    .createdBy(user.getUsername())
                    .build();
            userChat.setUser(user);
            userChat.setChat(chat);

            session.save(userChat);
//            user.getChats().clear();

//            var chat = Chat.builder()
//                    .name("dmdev")
//                    .build();
//            user.addChat(chat);
//
//            session.save(chat);

            session.getTransaction().commit();
        }
    }

    @Test
    void checkOneToOne() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var user = session.get(User.class, 13L);
            System.out.println();

//            var user = User.builder()
//                    .username("test5@gmail.com")
//                    .build();
//            var profile = Profile.builder()
//                    .language("ru")
//                    .street("Kolasa 18")
//                    .build();
//            profile.setUser(user);

//            session.save(user);
//            profile.setUser(user);
//            session.save(profile);

            session.getTransaction().commit();
        }
    }

    @Test
    void checkOrhanRemoval() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            Company company = session.getReference(Company.class, 1);
            company.getUsers().removeIf(user -> user.getId().equals(8L));

            session.getTransaction().commit();
        }
    }

    @Test
    void checkLazyInitialization() {
        Company company = null;
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            company = session.getReference(Company.class, 1);

            session.getTransaction().commit();
        }
        var users = company.getUsers();
        System.out.println(users.size());
    }

    @Test
    void getCompanyById() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = session.get(Company.class, 1);
        Hibernate.initialize(company.getUsers());
        System.out.println();

        session.getTransaction().commit();
    }


    @Test
    void deleteCompany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var user = session.get(User.class, 12L);
        session.delete(user);

        session.getTransaction().commit();
    }

    @Test
    void addUserToNewCompany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = Company.builder()
                .name("Facebook")
                .build();

        var user = User.builder()
                .username("sveta@gmail.com")
                .build();
        company.addUser(user);

        session.save(company);

        session.getTransaction().commit();
    }

    @Test
    void oneToMany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = session.get(Company.class, 1);
//        var user = User.builder()
//                .username("sveta@gmail.com")
//                .company(company)
//                .build();
        System.out.println(company.getUsers());
//        company.addUser(user);

        session.getTransaction().commit();
    }

    @SneakyThrows
    @Test
    void checkGetReflectionApi() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.getString("username");
        resultSet.getString("lastname");
        resultSet.getString("username");

        Class<User> clazz = User.class;

        Constructor<User> constructor = clazz.getConstructor();
        User user = constructor.newInstance();
        Field usernameField = clazz.getDeclaredField("username");
        usernameField.setAccessible(true);
        usernameField.set(user, resultSet.getString("username"));
    }


    @Test
    void checkReflectionApi() throws SQLException, IllegalAccessException {
        User user = User.builder()
                .build();

        String sql = """
                INSERT
                %s
                (%s)
                values
                (%s)
                """;

        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(table -> table.schema() + "." + table.name())
                .orElse(user.getClass().getName());

        Field[] declaredFields = user.getClass().getDeclaredFields();

        String columnNames = Arrays.stream(declaredFields)
                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName()))
                .collect(joining(", "));

        String columnValues = Arrays.stream(declaredFields)
                .map(field -> "?")
                .collect(joining(", "));

        System.out.println(sql.formatted(tableName, columnNames, columnValues));
    }
}