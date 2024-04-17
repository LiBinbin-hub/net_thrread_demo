package com.practice.demos.threadDemo.practiceDemo.threadCommunication.eg3;

public class MainTest {
    public static void main(String[] args) {
        MyRunnable1 myRunnable = new MyRunnable1();
        for (int i = 0; i < 100; i++) {
            new Thread(myRunnable).start();
        }
    }
}
