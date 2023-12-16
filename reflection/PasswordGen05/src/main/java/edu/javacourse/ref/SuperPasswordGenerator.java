package edu.javacourse.ref;

import edu.javacourse.ref.annotation.Generator;

public class SuperPasswordGenerator {

    private String algorithm;
    private String name;

    private SuperPasswordGenerator(String algorithm, String name) {
        this.algorithm = algorithm;
        this.name = name;
    }

    @Generator
    private String createPassword() {
        return "Super password" + algorithm + "," + name;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
