package com.practice.demos.threadDemo.practiceDemo.threadCommunication.eg3;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable1 implements Runnable {
    private final AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("count=" + count.incrementAndGet());
        }
    }
}
