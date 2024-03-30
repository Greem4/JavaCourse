package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.map.allmap;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> translations = new HashMap<>();

        translations.put("кошка", "cat");
        translations.put("собака", "dog");
        translations.put("слон", "elephant");

        for (Map.Entry<String, String> entry :  translations.entrySet() ) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        translations.entrySet().stream()
                .map(e -> e.getKey() + " : " + e.getValue())
                .forEach(System.out::println);
    }

}
