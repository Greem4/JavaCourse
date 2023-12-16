package edu.javacourse.ref;

import edu.javacourse.ref.annotation.Generator;

public class PasswordGeneratorThird {
    @Generator
    public String generate() {
        return "Third password";
    }
}
