package edu.javaAlishev.algorithmsanddatastructures.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList= new ArrayList<>();

//        measureTime(linkedList);
        measureTime(arrayList);
    }
    private static void measureTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
