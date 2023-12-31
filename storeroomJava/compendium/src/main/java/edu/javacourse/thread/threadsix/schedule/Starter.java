package edu.javacourse.thread.threadsix.schedule;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(LocalDateTime.now());

        ScheduledExecutorService ses = new ScheduledThreadPoolExecutor(2);

//        ses.schedule(new Task(), 1, TimeUnit.SECONDS);

        ses.scheduleAtFixedRate(new Task(),1, 3, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task(),1, 3, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task(),1, 3, TimeUnit.SECONDS);

//        ses.scheduleWithFixedDelay(new Task(), 1, 2, TimeUnit.SECONDS);

        Thread.sleep(20000);
        ses.shutdown();
    }
}
