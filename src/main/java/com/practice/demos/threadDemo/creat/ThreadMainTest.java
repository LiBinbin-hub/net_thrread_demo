package com.practice.demos.threadDemo.creat;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadMainTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //继承Thread类
        Thread myThread = new MyThread("继承Thread类：");
        myThread.start();
        // 实现Runnable接口
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        //匿名创建
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("匿名创建子线程输出：" + i);
            }
        }, "子线程2").start();

        // 继承Callable接口
        FutureTask<Number> futureTask = new FutureTask<>(new MyCallable());
        Thread thread1 = new Thread(futureTask, "实现Callable接口输出：");
        thread1.start();
        Number number = futureTask.get();
        System.out.println(thread1.getName() + number.toString());

        //匿名实现
        FutureTask<Number> futureTask1 = new FutureTask<>(() -> 22222);
        Thread thread2 = new Thread(futureTask1, "实现Callable接口输出：");
        thread2.start();
        Number number1 = futureTask1.get();
        System.out.println(thread2.getName() + number1.toString());

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出: " + i);
        }
    }
}
