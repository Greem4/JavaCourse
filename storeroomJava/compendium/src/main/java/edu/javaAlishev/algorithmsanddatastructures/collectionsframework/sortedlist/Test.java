package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.sortedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> animal = new ArrayList<>();

        animal.add("Mamma");
        animal.add("dog");
        animal.add("cat");
        animal.add("frog");
        animal.add("ad");
        animal.add("bird");
        animal.add("a");

        animal.sort(new StringLengthComparator());
        System.out.println(animal);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

//        Collections.sort(numbers);
        numbers.sort(new BackwardsComparator());
        System.out.println(numbers);
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        /*
           o1 > o2 => 1;   compere(2, 1) => 1;
           o1 < o2 => -1;  compere(1, 2) => -1;
           o1 == o2 => 0;  compere(1, 1) => 0;
         */
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        }
        return 0;
    }
}
class BackwardsComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
