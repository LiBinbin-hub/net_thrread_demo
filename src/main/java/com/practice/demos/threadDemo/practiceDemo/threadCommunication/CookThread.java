package com.practice.demos.threadDemo.practiceDemo.threadCommunication;

public class CookThread extends Thread {

    private final Desk desk;

    CookThread(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        desk.put();
    }
}
