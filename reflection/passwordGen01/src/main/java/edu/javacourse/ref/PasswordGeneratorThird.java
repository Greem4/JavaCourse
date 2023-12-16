package edu.javacourse.ref;

public class PasswordGeneratorThird implements PasswordGenerator {

    static {
        System.out.println("PasswordGeneratorThird");
    }

    @Override
    public String generate() {
        return "Third password";
    }
}
