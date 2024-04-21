package edu.javaAlishev.lambdaexpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Goodbye");
        list.add("a");
        list.add("ab");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.length() > t1.length()) {
                    return 1;
                }
                if (s.length() < t1.length()) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(list);

        list.sort((s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            if (s1.length() < s2.length()) return -1;
            return 0;
        });
        System.out.println(list);
    }
}
