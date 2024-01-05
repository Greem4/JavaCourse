package edu.javacourse.bit;

import java.util.Locale;

public class Starter {
    public static void main(String[] args) {
        byte a = 1;
        byte b = 3;
        int i1 = (byte) (a | b);
        System.out.println(i1);

        System.out.println("--------->>>>>>>>>>");

        byte a1 = 0;
        System.out.println(~a1);

        System.out.println("--------->>>>>>>>>>");

        int i = 1;
        while (i < 256) {
            System.out.println(i);
            i = i << 1;
        }

        System.out.println("--------->>>>>>>>>>");

        int i2 = 1;
        while (i2 < 257) {
            System.out.println(i2);
            i2 = i2 << 2;
        }

        System.out.println("--------->>>>>>>>>>");

        int i3 = 256;
        while (i3 > 0) {
            System.out.println(i3);
            i3 = i3 >> 1;
        }


    }
}
