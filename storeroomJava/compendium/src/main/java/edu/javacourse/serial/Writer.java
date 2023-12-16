package edu.javacourse.serial;

import java.io.*;

public class Writer {

    public static void main(String[] args) {
        testWrite();
    }

    private static void testWrite() {
        Second first = new Second();
        first.setFirstCode("FirstCode");
        first.setFirstName("FirstName");
        first.setSecondCode("SecondCode");
        first.setSecondName("SecondName");



        try (FileOutputStream fs = new FileOutputStream("out.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fs)) {

            oos.writeObject(first);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
