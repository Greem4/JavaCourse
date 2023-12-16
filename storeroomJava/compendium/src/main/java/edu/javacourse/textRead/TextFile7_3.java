package edu.javacourse.textRead;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;

public class TextFile7_3 {



    public static void main(String[] args) {

        final String fileName = "src/test2.txt";

        List<String> list = readList_7(fileName);
        for (String s : list) {
            System.out.println(s);
        }
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }

    private static List<String> readList_7(String fileName) {
        List<String> result = new LinkedList<>();

        try (InputStreamReader fr =
                     new InputStreamReader(new FileInputStream(fileName));
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {

        }
        return result;

    }
}
