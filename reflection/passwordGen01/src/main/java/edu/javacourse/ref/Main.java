package edu.javacourse.ref;

public class Main {

    public static void main(String[] args) {
        PasswordGenerator pgf = PasswordGeneratorFactory.getPasswordGenerator();
        String passw = pgf.generate();
        System.out.println(passw);
    }
}
