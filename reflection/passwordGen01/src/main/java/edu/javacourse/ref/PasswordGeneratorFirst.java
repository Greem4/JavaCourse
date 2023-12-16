package edu.javacourse.ref;

public class PasswordGeneratorFirst implements PasswordGenerator {

    static {
        System.out.println("PasswordGeneratorFirst");
    }
    @Override
    public String generate() {
        return "First Password";
    }
}
