package edu.javacourse.inteface.interface3;

public class Starter {
    public static void main(String[] args) {
        Hello h1 = Hello.getInstance("ONE");
        h1.sayHello();

        Hello h2 = Hello.getInstance("TWO");
        h2.sayHello();
    }
}
