package edu.greem4.http.util;

public class TestDriver {
    public static void main(String[] args) {
        try {
            String driver = "org.postgresql.Driver"; // Укажите драйвер напрямую
            Class.forName(driver);
            System.out.println("Драйвер успешно загружен.");
        } catch (ClassNotFoundException e) {
            System.err.println("Не удалось загрузить драйвер: " + e.getMessage());
        }
    }
}

