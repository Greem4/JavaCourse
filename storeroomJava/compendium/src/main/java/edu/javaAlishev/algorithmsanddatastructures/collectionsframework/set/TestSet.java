package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("Mike");
        hashSet.add("Kate");
        hashSet.add("Tom");
        hashSet.add("George");
        hashSet.add("Donald");

        for (String name : hashSet) {
            System.out.println(name);
        }

        System.out.println("-----");

        linkedHashSet.add("Mike");
        linkedHashSet.add("Kate");
        linkedHashSet.add("Tom");
        linkedHashSet.add("George");
        linkedHashSet.add("Donald");

        for (String name : linkedHashSet) {
            System.out.println(name);
        }

        System.out.println("-----");

        treeSet.add("Mike");
        treeSet.add("Kate");
        treeSet.add("Tom");
        treeSet.add("George");
        treeSet.add("Donald");

        for (String name : treeSet) {
            System.out.println(name);
        }


    }
}
