package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.map.allmap;

import java.util.*;

public class MapTest2 {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();  // внутри нет порядка
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // в каком порядке добавлены, в таком и вернутся
        Map<Integer, String> treeMap = new TreeMap<>(); // сортировка по ключу

        testMap(hashMap);
        System.out.println("------");
        testMap(linkedHashMap);
        System.out.println("------");
        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Tim");
        map.put(1500, "Lewis");
        map.put(7, "Bob");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
