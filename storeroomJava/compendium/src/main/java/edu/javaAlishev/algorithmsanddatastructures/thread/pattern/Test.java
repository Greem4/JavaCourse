package edu.javaAlishev.algorithmsanddatastructures.thread.pattern;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(() -> {
            try {
                wn.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                wn.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started...");
            wait(); // 1 - отдаем intrinsic lock, 2 - ждем пока будет вызван notify().
            System.out.println("Producer thread resumed...");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(2000);
            Scanner scanner = new Scanner(System.in);

            synchronized (this) {
                System.out.println("Waiting for return key pressed");
                scanner.nextLine();
                notify();

                Thread.sleep(5000);
            }
        }
    }
}
