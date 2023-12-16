package edu.javacourse.inteface;

public class MyClass3 implements MyInterface1, MyInterface2 {
    @Override
    public void sayHello() {

    }

    @Override
    public void sayHi() {
        System.out.println("HI 3");
    }
}
