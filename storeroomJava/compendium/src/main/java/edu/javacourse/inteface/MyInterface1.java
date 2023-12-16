package edu.javacourse.inteface;

public interface MyInterface1 {

    void sayHello();

    default void sayHi() {
        System.out.println("HI 1");
    }

    static void sayStatic() {
        System.out.println("HI static");
    }
}
