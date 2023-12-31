package edu.javacourse.inteface.interface3;

public class HelloOne implements Hello{
    @Override
    public void sayHello() {
        System.out.println("Hello One");
    }

    @Override
    public String getName() {
        return "ONE";
    }
}
