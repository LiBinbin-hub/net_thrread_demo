package com.practice.demos.threadDemo.practiceDemo.threadCommunication.eg2;

public class MyRunnable1 implements Runnable {
    private long count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                try {
                    System.out.println("count=" + (++count));
                    //Thread.sleep(500);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
