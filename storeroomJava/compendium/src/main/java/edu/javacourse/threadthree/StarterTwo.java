package edu.javacourse.threadthree;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StarterTwo {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(5);

        Future<Integer> sub = es.submit(new MyCallable());

        Thread.sleep(1000);
        sub.cancel(true);
//        while (!sub.isDone()) {
//            System.out.println("Is not done");
//            Thread.sleep(1000);
//        }
//        Integer id = sub.get();
//        System.out.println(id);
        System.out.println(sub.isCancelled());
        System.out.println("Shutdown");
        es.shutdown();
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("Started:" + Thread.currentThread().getId());
            Thread.sleep(1);
            Long d1 = System.currentTimeMillis();
            Long d2 = System.currentTimeMillis();
            while (d2 < d1 + 5000) {
                d2 = System.currentTimeMillis();
            }
            System.out.println("Finish:" + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
        return 99;
    }
}
