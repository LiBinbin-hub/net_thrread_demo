package com.practice.demos.threadDemo.practiceDemo.threadCommunication.eg4;

import java.util.ArrayList;
import java.util.List;

public class MainTest3 {

    private static int limit = 99;

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add("礼物" + (i + 1));
        }
        System.out.println(list);

        new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    synchronized (list) {
                        String name = Thread.currentThread().getName();
                        if (list.size() <= 10) {
                            System.out.println(name + "累计发送:" + count);
                            break;
                        }
                        String remove = list.remove(limit);
                        System.out.println(name + "发送" + remove);
                        count++;
                        limit--;
                    }
                }
            }
        }, "小红").start();

        new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    synchronized (list) {
                        String name = Thread.currentThread().getName();
                        if (list.size() <= 10) {
                            System.out.println(name + "累计发送:" + count);
                            break;
                        }
                        String remove = list.remove(limit);
                        System.out.println(name + "发送" + remove);
                        limit--;
                        count++;
                    }
                }
            }
        }, "小明").start();

    }
}
