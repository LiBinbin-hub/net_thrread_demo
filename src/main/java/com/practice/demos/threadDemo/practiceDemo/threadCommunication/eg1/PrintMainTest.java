package com.practice.demos.threadDemo.practiceDemo.threadCommunication.eg1;

public class PrintMainTest {
    public static void main(String[] args) throws InterruptedException {
        MyPrintln myPrintln = new MyPrintln();
        Thread threadA = new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                while (i < 50) {
                    myPrintln.printlnA(i);
                    i++;
                }
            }
        }, "A线程");
        Thread threadB = new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                while (i < 50) {
                    myPrintln.printlnB(i);
                    i++;
                }
            }
        }, "B线程");
        threadA.start();
        threadB.start();
        //Thread.sleep(10000);
    }
}
