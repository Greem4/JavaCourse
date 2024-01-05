package edu.javacourse.sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Starter {
    public static void main(String[] args) {
        List<String> init = new ArrayList<>();
//        List<String> init = Collections.synchronizedList(new ArrayList<>());
        init.add("Name: -1");
        init.add("Name: -2");

        List<Person> test = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            test.add(new Person((long) i, "Name:" + i));
        }

//        test.parallelStream()
//                .map(Person::getName)
//                .forEach(init::add);
//        System.out.println("FINISH" + init.size());
        List<String> res = test.parallelStream()
                .map(Person::getName)
                .toList();
        init.addAll(res);
        System.out.println("FINISH" + init.size());
    }
}

class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
