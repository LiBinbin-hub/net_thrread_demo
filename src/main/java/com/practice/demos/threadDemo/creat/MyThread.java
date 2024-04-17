package com.practice.demos.threadDemo.creat;

public class MyThread extends Thread {

    private String name;

    MyThread(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + i);
        }
    }
}
