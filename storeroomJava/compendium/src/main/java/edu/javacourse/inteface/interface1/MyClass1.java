package edu.javacourse.inteface.interface1;

public class MyClass1 implements MyInterface1, MyInterface2 {
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }

    @Override
    public void sayHi() {
        MyInterface1.super.sayHi();
    }
}