package edu.javacourse.ref;

public class PasswordGeneratorSecond implements PasswordGenerator {

    static {
        System.out.println("PasswordGeneratorSecond");
    }
    @Override
    public String generate() {
        return "Second password";
    }
}
