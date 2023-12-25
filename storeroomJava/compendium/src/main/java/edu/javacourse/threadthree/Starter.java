package edu.javacourse.threadthree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Starter {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(5);

        Future<?> sub = es.submit(new MyRunnable());

//        while (!sub.isDone()) {
//            System.out.println("Is not done");
//            Thread.sleep(1000);
//        }
        sub.get();

        System.out.println("Shutdown");
        es.shutdown();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Started:" + Thread.currentThread().getId());
            Thread.sleep(5000);
            System.out.println("Finish:" + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
