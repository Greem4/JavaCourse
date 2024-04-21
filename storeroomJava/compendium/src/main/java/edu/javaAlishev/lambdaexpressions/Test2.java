package edu.javaAlishev.lambdaexpressions;

interface Executable {
    int execute(int x, int y);
}

class Runner {
    public void run(Executable e) {
        int a = e.execute(10, 15);
        System.out.println(a);
    }
}


public class Test2 {
    public static void main(String[] args) {
        Runner runner = new Runner();

        int a = 1;
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                int a = 2;
                return x + y;
            }
        });

        int b = 2;
        runner.run((x, y) -> x + y + b);
    }
}
