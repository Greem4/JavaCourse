package edu.javacourse.serial;

import java.io.*;

public class Reader {

    public static void main(String[] args) {
        testRead();
    }

    private static void testRead() {
        try (FileInputStream fs = new FileInputStream("out.dat");
             ObjectInputStream ois = new ObjectInputStream(fs)) {

            Second first = (Second) ois.readObject();
            System.out.println(first.getFirstCode());
            System.out.println(first.getFirstName());
            System.out.println(first.getSecondCode());
            System.out.println(first.getSecondName());

        } catch (IOException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }
}
