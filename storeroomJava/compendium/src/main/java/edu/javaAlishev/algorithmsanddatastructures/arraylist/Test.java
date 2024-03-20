package edu.javaAlishev.algorithmsanddatastructures.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    /**
    Принято обьявлять ArrayList по интерфейсу List, так как можно изменить
     реализацию на ходу
     */
    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            arrayList.add(i);
//        }
//        arrayList.remove(5);
//        arrayList.forEach(System.out::println);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(5);
        list.forEach(System.out::println);
        System.out.println("--------");

        list = new LinkedList<>(list);
        list.remove(3);
        list.forEach(System.out::println);
    }
}
