package edu.javacourse.simple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        List<String> test = Arrays.asList("1", "2", "3", "4", "5");

        for (Iterator<String> it = test.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

        System.out.println();

        for (String s : test) {
            System.out.println(s);
        }

        System.out.println();

        test.forEach(System.out::println);
    }
}
