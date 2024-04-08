package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.sortedlist;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
//        if (this.name.length() > o.getName().length()) {
//            return 1;
//        }
//        if (this.name.length() < o.getName().length()) {
//            return -1;
//        }
//        return 0;
        return Integer.compare(this.name.length(), o.getName().length());
    }
}
