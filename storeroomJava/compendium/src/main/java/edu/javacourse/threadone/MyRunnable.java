package edu.javacourse.threadone;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Start Runnable:" + Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish Runnable:" + Thread.currentThread().getId());
    }
}
