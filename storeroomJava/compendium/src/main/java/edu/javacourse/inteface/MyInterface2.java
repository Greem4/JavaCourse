package edu.javacourse.inteface;

public interface MyInterface2 {
    default void sayHi() {
        System.out.println("HI 2");
    }
}
