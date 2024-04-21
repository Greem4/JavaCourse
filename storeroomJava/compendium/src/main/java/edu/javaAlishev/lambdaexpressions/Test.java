package edu.javaAlishev.lambdaexpressions;

interface Executable1 {
    void execute();
}

class Runner1 {
    public void run(Executable1 e) {
        e.execute();
    }
}

class ExecutableImpl implements Executable1 {

    @Override
    public void execute() {
        System.out.println("Hello World!");
    }
}

public class Test {
    public static void main(String[] args) {
        Runner1 runner = new Runner1();

        runner.run(new ExecutableImpl());

        runner.run(new Executable1() {
            @Override
            public void execute() {
                System.out.println("Hello World!");
            }
        });

        runner.run(() -> System.out.println("Hello World!"));
    }
}
