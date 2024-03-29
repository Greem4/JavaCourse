package edu.javaAlishev.algorithmsanddatastructures.map;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Тройка");

        for (Map.Entry<Integer, String> entry :map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
