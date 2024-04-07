package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.sortedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class TestThree {
    public static void main(String[] args) {
        List<String> animal = new ArrayList<>();

        animal.add("Mamma");
        animal.add("dog");
        animal.add("cat");
        animal.add("frog");
        animal.add("ad");
        animal.add("bird");
        animal.add("a");

        animal.sort(Comparator.comparingInt(String::length));
        System.out.println(animal);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}

