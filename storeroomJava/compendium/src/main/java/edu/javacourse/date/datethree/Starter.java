package edu.javacourse.date.datethree;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Starter {
    public static void main(String[] args) {
        LocalDateTime d = LocalDateTime.of
                (2018, 3, 12, 15, 45, 30);

        LocalDate d1 = LocalDate.from(d);
        LocalDate d2 = d1.minusMonths(2);

        System.out.println(d);
        System.out.println(d1);
        System.out.println(d2);
    }
}
