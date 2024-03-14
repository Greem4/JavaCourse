package edu.javaAlishev.sorttest;

import java.util.Arrays;
import java.util.Collections;

public class SortV3 {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(maxNumberFromDigits(digits));
    }

    private static String maxNumberFromDigits(int[] digits) {
        return String.join("",Arrays.stream(digits).boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));
    }
}
