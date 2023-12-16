package edu.javacourse.ref;

import edu.javacourse.ref.annotation.Generator;

public class SuperPasswordGenerator {
    public void aTest() {}
    @Generator
    public String createPassword() {
        return "Super password";
    }


}
