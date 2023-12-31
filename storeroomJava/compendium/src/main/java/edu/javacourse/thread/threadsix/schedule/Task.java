package edu.javacourse.thread.threadsix.schedule;

import java.time.LocalDateTime;

public class Task implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("Start task " + LocalDateTime.now());
            Thread.sleep(2000);
            System.out.println("Finish task " + LocalDateTime.now());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
