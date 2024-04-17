package com.practice.demos.threadDemo.practiceDemo.threadCommunication;

import java.util.ArrayList;
import java.util.List;

public class Desk {
    private final List<String> list = new ArrayList<>();
    private boolean flag = false;

    public synchronized void put() {
        try {
            if (list.size() < 3) {
                String name = Thread.currentThread().getName();
                list.add("包子");
                System.out.println(name + "做了1个包子," + "现在有" + list.size() + "个包子");
                Thread.sleep(2 * 1000);
                if (list.size() == 3) {
                    flag = true;
                }
            }
            this.notify();
            this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized void get() {
        try {
            String name = Thread.currentThread().getName();
            if (list.size() < 3 && !flag) {
                this.notify();
                this.wait();
                return;
            }
            if (list.size() > 0 && flag) {
                System.out.println(name + "吃了1个" + list.get(0));
                //list.clear();
                list.remove(list.size() - 1);
                System.out.println("现在还剩" + list.size() + "个包子");
                Thread.sleep(2 * 1000);
            }
            this.notify();
            this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
