package edu.javacourse.date.datetwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Starter {
    private static final String SQL = "INSERT INTO check_date" +
            " (first, second, third) VALUES(?,?,?)";

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");

        Starter s = new Starter();
        s.writeDate(new Date());
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/pantry",
                "greem", "4145");
    }

    public void writeDate(Date d) throws SQLException {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(SQL)) {
            st.setDate(1, new java.sql.Date(d.getTime()));
            st.setTime(2, new java.sql.Time(d.getTime()));
            st.setTimestamp(3, new java.sql.Timestamp(d.getTime()));
            st.executeUpdate();
        }
    }


}
