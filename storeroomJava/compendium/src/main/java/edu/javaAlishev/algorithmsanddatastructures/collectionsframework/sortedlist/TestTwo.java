package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.sortedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestTwo {
    public static void main(String[] args) {
        List<String> animal = new ArrayList<>();

        animal.add("Mamma");
        animal.add("dog");
        animal.add("cat");
        animal.add("frog");
        animal.add("ad");
        animal.add("bird");
        animal.add("a");

        animal.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
//                if (s.length() > t1.length()) {
//                    return 1;
//                }
//                if (s.length() < t1.length()) {
//                    return -1;
//                }
//                return 0;
                return s.length() - t1.length();
            }
        });
        System.out.println(animal);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

//        Collections.sort(numbers);
        numbers.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer);
            }
        });
        System.out.println(numbers);
    }
}

