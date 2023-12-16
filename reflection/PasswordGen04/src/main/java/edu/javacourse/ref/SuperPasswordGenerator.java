package edu.javacourse.ref;

import edu.javacourse.ref.annotation.Generator;

public class SuperPasswordGenerator {

    private String algorithm;
    private String name;


    @Generator
    private String createPassword() {
        return "Super password" + algorithm + "," + name;
    }



}
