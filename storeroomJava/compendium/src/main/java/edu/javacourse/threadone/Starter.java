package edu.javacourse.threadone;

public class Starter {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread m = new MyThread();
            m.start();
        }

        for (int i = 0; i < 5; i++) {
            MyRunnable m = new MyRunnable();
            Thread t = new Thread(m);
            t.start();
        }
    }
}
