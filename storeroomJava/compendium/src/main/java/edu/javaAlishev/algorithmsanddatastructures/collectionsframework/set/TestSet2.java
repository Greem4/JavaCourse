package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.set;

import java.util.HashSet;
import java.util.Set;

public class TestSet2 {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("Mike");
        hashSet.add("Kate");
        hashSet.add("Tom");
        hashSet.add("George");
        hashSet.add("Donald");

        System.out.println(hashSet.contains("Tom"));
        System.out.println(hashSet.contains("Tim"));

        System.out.println(hashSet.isEmpty());
    }
}
