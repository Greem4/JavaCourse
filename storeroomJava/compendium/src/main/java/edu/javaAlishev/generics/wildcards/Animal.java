package edu.javaAlishev.generics.wildcards;

public class Animal {
    private int id;

    public Animal() {
    }
    public void eat() {
        System.out.println("Animal is eating....");
    }

    public Animal(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
