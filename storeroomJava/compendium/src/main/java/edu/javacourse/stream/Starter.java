package edu.javacourse.stream;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person("name_" + i, Math.random() + 1));
        }

        List<Double> grades = persons.stream()
                .map(Person::getGrade)
                .filter(g -> g > 1.5)
                .toList();
        grades.forEach(System.out::println);

        System.out.println();

        persons.stream()
                .map(Person::getName)
                .filter(n -> n.endsWith("5"))
                .toList()
                .forEach(System.out::println);
    }
}
