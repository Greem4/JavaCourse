package edu.javacourse.thread.threadfour;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Starter {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(10);

        List<MyCallable> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MyCallable mc = new MyCallable();
            tasks.add(mc);
        }

//        List<Future<Long>> futures = es.invokeAll(tasks);
        Long aLong = es.invokeAny(tasks);
        System.out.println(aLong);
//        for (Future<Long> f : futures) {
//            System.out.println(f.get());
//        }

        System.out.println("FINISH");
        es.shutdown();
    }
}

class MyCallable implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        try {

            System.out.println("Started:" + Thread.currentThread().getId());
            Thread.sleep(1000 + Math.round(Math.random() * 5000));
            System.out.println("Finished:" + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getId();
    }
}