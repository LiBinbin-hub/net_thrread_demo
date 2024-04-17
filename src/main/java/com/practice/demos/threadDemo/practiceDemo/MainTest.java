package com.practice.demos.threadDemo.practiceDemo;

import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

public class MainTest {
    public static void main(String[] args) {

        Account account = new Account(1000);

        //小红取钱
        new Thread(() -> account.drawMoney(1000, "小红")).start();
        //小明取钱
        FutureTask<Double> futureTask = new FutureTask<>(() -> {
            account.drawMoney(1000, "小明");
            return null;
        });
        new Thread(futureTask).start();

        //加锁实现同步
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
//        {
//            锁之间的逻辑代码
//        }
        reentrantLock.unlock();
    }
}
