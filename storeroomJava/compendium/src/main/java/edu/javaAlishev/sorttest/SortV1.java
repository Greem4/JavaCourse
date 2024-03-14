package edu.javaAlishev.sorttest;

import java.util.Arrays;
import java.util.Comparator;

public class SortV1 {
    public static void main(String[] args) {
//        Integer[] numbers = {3, 30, 34, 5, 4, 6, 7};
        Integer[] numbers = {3, 1, 7, 9, 9, 5};

        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String num1 = String.valueOf(a);
                String num2 = String.valueOf(b);
                return (num2 + num1).compareTo(num1 + num2);
            }
        });
        StringBuilder result = new StringBuilder();
        for (Integer num : numbers) {
            result.append(num);
        }

        System.out.println("Наибольшее число их массива: " + result);
    }
}
