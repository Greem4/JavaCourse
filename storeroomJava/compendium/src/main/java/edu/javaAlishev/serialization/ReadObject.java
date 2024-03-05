package edu.javaAlishev.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.bin"))) {
            Person[] people = (Person[]) ois.readObject();
            System.out.println(Arrays.toString(people));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
