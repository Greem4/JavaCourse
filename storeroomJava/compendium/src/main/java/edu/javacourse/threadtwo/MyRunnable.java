package edu.javacourse.threadtwo;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Start Runnable:" + Thread.currentThread().getId());
            System.out.println("Start Runnable:" + getClass().getSimpleName());
            Thread.sleep(5000);
            System.out.println("Finish Runnable:" + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
