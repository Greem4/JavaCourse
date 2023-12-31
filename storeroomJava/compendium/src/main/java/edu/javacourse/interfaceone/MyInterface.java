package edu.javacourse.interfaceone;

public interface MyInterface {
    void sayHello();
    public static MyInterface getInstance() {
        return new MyClass1();
    }
}
