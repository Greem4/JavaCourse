package edu.javacourse.hash;

import java.util.HashSet;
import java.util.Set;

public class Starter {
    public static void main(String[] args) {
//        if (m1.equals(m2)) {
//            System.out.println("OK");
//            System.out.println(m1.hashCode());
//            System.out.println(m2.hashCode());
//        }

        Set<MyClass> set = new HashSet<>();
        System.out.println("1");
        set.add(new MyClass(11L, "name1"));
        System.out.println("2");
        set.add(new MyClass(12L, "name2"));
        System.out.println("3");
        set.add(new MyClass(13L, "name3"));
        System.out.println("4");
        set.add(new MyClass(11L, "name1"));

        System.out.println("SIZE:" + set.size());
    }
}
