package edu.javacourse.thread.threadfive;

import java.util.concurrent.*;

public class Starter {
    public static void main(String[] args) {
//        ThreadPoolExecutor es = new ThreadPoolExecutor(
//                2,4,1,
//                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(2),
//                new MyReject()
//        );

        ThreadPoolExecutor es = new ThreadPoolExecutor(
                2,4,1,
                TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
                new MyReject()
        );
        for (int i = 0; i < 7; i++) {
            MyCallable mc = new MyCallable();
            es.submit(mc);
        }

        es.shutdown();
    }
}

class MyReject implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        System.out.println("REJECTED");
    }
}

class MyCallable implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        try {
            System.out.println("Thread started:" + Thread.currentThread().getId());
            Thread.sleep(2000);
            System.out.println("Thread finished:" + Thread.currentThread().getId());
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Thread.currentThread().getId();
    }
}