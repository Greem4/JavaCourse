package com.greem4.jdbc.starter;

import com.greem4.jdbc.starter.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
        try (var connection = ConnectionManager.open()) {
            try (var statement = connection.createStatement()) {
                System.out.println(connection.getTransactionIsolation());
            }
        }
    }
}
