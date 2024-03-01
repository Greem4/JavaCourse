package edu.javaAlishev.readingfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFromFile {
    private static final String PATH = "/home/greem/test.txt";
    public static void main(String[] args) {
        File file = new File(PATH);

        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            String[] numbersString = line.split(" ");
            int[] numbers = new int[3];
            int counter = 0;

            for (String number : numbersString) {
                numbers[counter++] = Integer.parseInt(number);
            }
            System.out.println(Arrays.toString(numbers));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
