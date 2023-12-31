package edu.javacourse.interfaceone;

public class Starter {
    public static void main(String[] args) {
        MyInterface mi = MyInterface.getInstance();
        mi.sayHello();
    }
}
