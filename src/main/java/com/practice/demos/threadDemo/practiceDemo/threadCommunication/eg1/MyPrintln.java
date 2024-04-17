package com.practice.demos.threadDemo.practiceDemo.threadCommunication.eg1;

public class MyPrintln {

    private boolean flag = false;

    public synchronized void printlnA(int i) {
        try {
            if (!flag) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在打印字母：" + "A;" + "第" + i + "次打印。");
                //Thread.sleep(1000);
                flag = true;
            }
            this.notify();
            this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void printlnB(int i) {
        try {
            if (flag) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在打印字母：" + "B;" + "第" + i + "次打印。");
                //Thread.sleep(1000);
                flag = false;
            }
            this.notify();
            this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
