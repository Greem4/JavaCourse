package edu.javacourse.databaseSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBExample {

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");

        Contact contact = new Contact(null, "11", "22", "33", "44");
        testInsert(contact);
        testSelect();
    }

    private static void testSelect() {
        List<Contact> result = new ArrayList<>();
        String url = "jdbc:postgresql://localhost:5432/javacourse";
        try {
            Connection con = DriverManager.getConnection(url, "greem", "4145");
            Statement stmt = null;
            ResultSet rs = null;
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM cm_contact");
                while (rs.next()) {
                    Long contactId = rs.getLong("contact_id");
                    String surName = rs.getString("sur_name");
                    String giveName = rs.getString("given_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    Contact contact = new Contact(contactId, surName, giveName, email, phone);
                    result.add(contact);
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Contact cnt : result) {
            System.out.println(cnt);
        }
    }

    private static void testInsert(Contact contact) {
        String url = "jdbc:postgresql://localhost:5432/javacourse";

        try {
            Connection con = DriverManager.getConnection(url, "greem", "4145");

            PreparedStatement stmt = null;
            try {
                con.setAutoCommit(false);
                stmt = con.prepareStatement("INSERT INTO cm_contact " +
                                "(sur_name, given_name, email, phone) values (?,?,?,?)",
                        new String[]{"contact_id"});

                for (int i = 0; i < 3; i++) {
                    stmt.setString(1, contact.getSurName());
                    stmt.setString(2, contact.getGiveName());
                    stmt.setString(3, contact.getEmail());
                    stmt.setString(4, contact.getPhone());
                    stmt.executeUpdate();

//                ResultSet rs = stmt.getGeneratedKeys();
//                if (rs.next()) {
//                    Long contactId = rs.getLong("contact_id");
//                    System.out.println("contact: " + contactId);
                }
                con.commit();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

