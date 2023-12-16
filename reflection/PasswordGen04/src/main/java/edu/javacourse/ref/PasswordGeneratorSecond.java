package edu.javacourse.ref;

import edu.javacourse.ref.annotation.Generator;

public class PasswordGeneratorSecond {
    @Generator
    public String generatePassword() {
        return "Second password";
    }
}
