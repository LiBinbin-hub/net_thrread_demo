package com.practice.demos.threadDemo.creat;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("实现Runnable接口的子线程输出: " + i);
        }
    }
}
