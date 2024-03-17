package edu.javaAlishev.algorithmsanddatastructures.sortlogn;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {11, 11, 12, 1, 3, 5, 6, 534, 66, 7435, 5, 44, 6};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(binarySearch(numbers, 44));
    }

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while(low <= high) {
            int middle = low + (high - low) / 2;

            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
