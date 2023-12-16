package xyz.testUnit;

public class Man {
    private final String name;
    private final String surName;
    private final int age;

    public Man(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getFullName() {
        return name + " " + surName;
    }

    public String getFullInfo() {
        return name + " " + surName + " age+ " + age;
    }
}
