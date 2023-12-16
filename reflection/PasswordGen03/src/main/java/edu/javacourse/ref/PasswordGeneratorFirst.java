package edu.javacourse.ref;


import edu.javacourse.ref.annotation.Generator;

public class PasswordGeneratorFirst  {
    @Generator
    public String buildPassword() {
        return "First Password";
    }
}
