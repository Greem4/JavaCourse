package edu.greem4.http.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

public final class ConnectionManager {

    private static final String URL_KEY = "db.url"; // Ключ для URL базы данных
    private static final String USER_KEY = "db.user"; // Ключ для имени пользователя
    private static final String PASSWORD_KEY = "db.password"; // Ключ для пароля

    static {
        loadDriver(); // Загружаем драйвер при инициализации класса
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private ConnectionManager() {
        // Приватный конструктор для предотвращения создания экземпляров
    }

    public static Connection get() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
