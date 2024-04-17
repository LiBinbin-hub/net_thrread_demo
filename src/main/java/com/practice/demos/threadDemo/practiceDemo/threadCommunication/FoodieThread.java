package com.practice.demos.threadDemo.practiceDemo.threadCommunication;

public class FoodieThread extends Thread {

    private final Desk desk;

    FoodieThread(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        desk.get();
    }
}
