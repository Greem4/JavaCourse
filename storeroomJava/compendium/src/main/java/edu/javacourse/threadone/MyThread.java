package edu.javacourse.threadone;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Start Thread:" + getId());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish Thread:" + getId());
    }
}
