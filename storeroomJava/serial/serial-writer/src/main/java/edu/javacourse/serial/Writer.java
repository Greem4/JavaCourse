package edu.javacourse.serial;

import java.io.*;

public class Writer {

    public static void main(String[] args) {
        testWrite();
    }

    private static void testWrite() {
        First first = new First();
        first.setFirstCode("FirstCode");
        first.setFirstName("FirstName");
        first.setFirstOther("FirstOther");



        try (FileOutputStream fs = new FileOutputStream("/home/greem/out.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fs)) {

            oos.writeObject(first);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
