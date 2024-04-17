package com.practice.demos.threadDemo.practiceDemo.threadCommunication.eg1;

public class PrintMainTest1 {

    static int index = 0;

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        new Thread(() -> {
            while (index < 100) {
                synchronized (lock) {
                    if (index % 2 == 0) {
                        System.out.println("A");
                        index++;
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (index < 100) {
                synchronized (lock) {
                    if (index % 2 == 1) {
                        System.out.println("B");
                        index++;
                    }
                }
            }
        }).start();

        //Thread.sleep(10000);
    }
}
