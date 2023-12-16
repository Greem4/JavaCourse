package edu.javacourse.serial;

import java.io.*;

public class Reader {

    public static void main(String[] args) {
        testRead();
    }

    private static void testRead() {
        try (FileInputStream fs = new FileInputStream("/home/greem/out.dat");
             ObjectInputStream ois = new ObjectInputStream(fs)) {

            First first = (First) ois.readObject();
            System.out.println(first.getFirstCode());
            System.out.println(first.getFirstName());

        } catch (IOException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }
}
