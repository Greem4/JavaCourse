package edu.javacourse.format;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class Starter {

    public static void main(String[] args) throws FileNotFoundException {
       formatter1();
       formatter2();

    }

    private static void formatter1() {
        String s = "%1$tY.%1$tm.%1td %1$tR переведена сумма в размере %5.2f руб. по счету № '%s'";

//        String answer = String.format(s, new Date(), 99.8, "AC12345");
        String answer = String.format(Locale.forLanguageTag("ru"),
                s, new Date(), 99.8, "AC12345");
        System.out.println(answer);
    }
    private static void formatter2() throws FileNotFoundException {
        String s = "%1$tY.%1$tm.%1td %1$tR переведена сумма в размере %5.2f руб. по счету № '%s'%n";

        try (Formatter fm = new Formatter(new File("out.txt"))) {
            fm.format(s, new Date(), 99.8, "AC12345");
            fm.format(s, new Date(), 99.8, "AC12345");
            fm.format(s, new Date(), 99.8, "AC12345");
        }
    }
}
