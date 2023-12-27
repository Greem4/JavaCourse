package edu.javacourse.thread.threadone;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("Start Runnable:" + Thread.currentThread().getId());
            Thread.sleep(5000);
            System.out.println("Finish Runnable:" + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
