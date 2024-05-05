package edu.javaAlishev.annotations;

import java.lang.annotation.Target;

public class Test {
    @MethodInfo(purpose = "Print Hello World")
    public void printHelloWorld() {
        System.out.println("Hello World!");
    }
}
