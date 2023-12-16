package edu.javacourse.textRead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TextFile7 {

    public static void main(String[] args) {
        final String fileName = "src/test.txt";

        List<String> list1 = readList_6(fileName);
        for (String s : list1) {
            System.out.println(s);
        }

        List<String> list2 = readList_7(fileName);
        for (String s : list2) {
            System.out.println(s);
        }

        List<String> list3 = readList_7_2(fileName);
        for (String s : list3) {
            System.out.println(s);
        }
    }



    private static List<String> readList_6(String fileName) {
        List<String> result = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
            } finally {
                br.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static List<String> readList_7(String fileName) {
        List<String> result = new LinkedList<>();

        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {

        }
        return result;

    }

    private static List<String> readList_7_2(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        }catch (IOException e) {

        }
        return Collections.EMPTY_LIST;
    }

}
