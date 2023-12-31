package edu.javacourse.inteface.interface3;

public class HelloTwo implements Hello{

    @Override
    public void sayHello() {
        System.out.println("Hello Two");
    }

    @Override
    public String getName() {
        return "TWO";
    }
}
