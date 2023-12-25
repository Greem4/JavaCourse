package edu.javacourse.date.datanewsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Starter {
    private static final String SQL = "INSERT INTO check_date" +
            " (first, second, third) VALUES(?,?,?)";

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");

        Starter s = new Starter();
        s.writeDate(LocalDateTime.now());
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/pantry",
                "greem", "4145");
    }

    public void writeDate(LocalDateTime d) throws SQLException {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(SQL)) {

            st.setDate(1, java.sql.Date.valueOf(LocalDate.from(d)));
            st.setTime(2, java.sql.Time.valueOf(LocalTime.from(d)));
            st.setTimestamp(3, java.sql.Timestamp.valueOf(d));

            st.executeUpdate();
        }
    }
}
