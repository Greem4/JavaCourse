package edu.javacourse.thread.threadtwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10, new MyFactory());

        for (int i = 0; i < 10; i++) {
            es.submit(new MyRunnable());
        }

        es.shutdown();
    }
}
class MyFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new SimpleThread(r);
    }
}
class SimpleThread extends Thread {
    public SimpleThread(Runnable task) {
        super(task);
    }
}
