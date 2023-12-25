package edu.javacourse.close;

import java.io.FileReader;

public class Starter {
    public static void main(String[] args) {
        try (Resource1 r1 = new Resource1();
             Resource2 r2 = new Resource2()) {

            throw  new RuntimeException("TEST");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
