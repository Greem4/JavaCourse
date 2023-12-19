package edu.javacourse.textRead;


import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class TextFile6 {
    public static void main(String[] args) {
        final String fileName = "src/test.txt";

        List<String> list = readList_6(fileName);
        for (String s : list) {
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
}
