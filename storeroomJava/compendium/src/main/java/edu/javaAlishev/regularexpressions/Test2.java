package edu.javaAlishev.regularexpressions;


import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String a = "Hello123123there3123123hey";
        String[] words = a.split("\\d+.");
        System.out.println(Arrays.toString(words));

        String b = "Hello4234234523there42342342hey";
        String modifiedString = b.replaceAll("\\d+", "-");
        String modifiedString2 = b.replaceFirst("\\d+", "-");
        System.out.println(modifiedString);
        System.out.println(modifiedString2);
    }
}
