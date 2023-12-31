package edu.javacourse.inteface.interface1;

public class Starter {
    public static void main(String[] args) {
        MyClass1 mc1 = new MyClass1();
        mc1.sayHello();

        mc1.sayHi();

        MyClass2 mc2 = new MyClass2();
        mc2.sayHi();

        MyClass3 mc3 = new MyClass3();
        mc3.sayHi();

        MyInterface1.sayStatic();
    }
}
