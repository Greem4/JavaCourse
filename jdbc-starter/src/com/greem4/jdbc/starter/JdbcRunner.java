package com.greem4.jdbc.starter;

import com.greem4.jdbc.starter.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        String flightId = "2";
        var result = getTicketsByFlightId(flightId);
        System.out.println(result);
    }

    private static List<Long> getTicketsByFlightId(String flightId) throws SQLException {
        String sql = """
                SELECT id
                FROM ticket
                WHERE flight_id = %s
                """.formatted(flightId);
        List<Long> result = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            var resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                result.add(resultSet.getObject("id", Long.class));
            }
        }

        return result;
    }
}

