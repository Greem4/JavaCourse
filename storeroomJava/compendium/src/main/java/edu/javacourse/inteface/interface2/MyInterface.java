package edu.javacourse.inteface.interface2;

public interface MyInterface {
    void sayHello();
    public static MyInterface getInstance() {
        return new MyClass1();
    }
}
