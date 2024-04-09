package edu.javaAlishev.algorithmsanddatastructures.thread.synchronize;

public class Test {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.doWork();
    }
    public synchronized void incrementCounter() {
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    incrementCounter();
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    incrementCounter();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
