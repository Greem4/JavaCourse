package edu.javaAlishev.algorithmsanddatastructures.thread.volatiles;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutDown();
    }
}

class MyThread extends Thread {
    private volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutDown() {
        this.flag = false;
    }
}
