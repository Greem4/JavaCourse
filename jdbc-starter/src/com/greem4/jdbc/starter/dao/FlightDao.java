package com.greem4.jdbc.starter.dao;

import com.greem4.jdbc.starter.entity.Flight;
import com.greem4.jdbc.starter.entity.Ticket;
import com.greem4.jdbc.starter.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_BY_ID_SQL = """
            SELECT id,
                flight_no,
                departure_date,
                departure_airport_code,
                arrival_date,
                arrival_airport_code,
                aircraft_id,
                status
            FROM flight
            WHERE id = ?
            """;

    private FlightDao() {

    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Flight save(Ticket ticket) {
        return null;
    }

    @Override
    public void update(Flight ticket) {

    }

    @SneakyThrows
    public Optional<Flight> findById(Long id, Connection connection) {
        try (var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);

            var resultSet = preparedStatement.executeQuery();
            Flight flight = null;
            if (resultSet.next()) {
                flight = new Flight(
                        resultSet.getLong("id"),
                        resultSet.getString("flight_no"),
                        resultSet.getTimestamp("departure_date").toLocalDateTime(),
                        resultSet.getString("departure_airport_code"),
                        resultSet.getTimestamp("arrival_date").toLocalDateTime(),
                        resultSet.getString("arrival_airport_code"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getString("status")
                );
            }
            return Optional.ofNullable(flight);
        }
    }

    @SneakyThrows
    @Override
    public Optional<Flight> findById(Long id) {
        try (var connection = ConnectionManager.get()) {
           return findById(id, connection);
        }
    }

    @Override
    public List<Flight> findAll() {
        return List.of();
    }
}
