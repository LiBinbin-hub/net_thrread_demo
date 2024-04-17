package com.practice.demos.threadDemo.practiceDemo.threadCommunication;

import java.util.concurrent.*;

public class MainTest {
    public static void main(String[] args) {
        Desk desk = new Desk();
        // 厨师做包子
//        new Thread(() -> {
//            while (true) {
//                desk.put();
//            }
//        }, "厨师1").start();
//
//        new Thread(() -> {
//            while (true) {
//                desk.put();
//            }
//        }, "厨师2").start();
//        //吃货吃包子
//        new Thread(() -> {
//            while (true) {
//                desk.get();
//            }
//        }, "吃货1").start();
//        new Thread(() -> {
//            while (true) {
//                desk.get();
//            }
//        }, "吃货2").start();
//        new Thread(() -> {
//            while (true) {
//                desk.get();
//            }
//        }, "吃货3").start();

        //线程池多次调用子线程处理任务
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(3
                , 5
                , 8, TimeUnit.SECONDS
                , new LinkedBlockingDeque<>(), Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());
        CookThread cookThread = new CookThread(desk);
        FoodieThread foodieThread = new FoodieThread(desk);
        int i = 0;
//        while (i < 100) {
//            i++;
//            threadPoolExecutor.execute(cookThread);
//            threadPoolExecutor.execute(cookThread);
//            threadPoolExecutor.execute(cookThread);
//            threadPoolExecutor.execute(foodieThread);
//            threadPoolExecutor.execute(foodieThread);
//            //===============测试何时启用临时线程
//        }

        // 创建指定线程数量的线程池， 其中线程出现异常会补上新的线程
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);


        ExecutorService executorService = Executors.newCachedThreadPool();
        while (i < 100) {
            i++;
            executorService.execute(cookThread);
            executorService.execute(cookThread);
            executorService.execute(cookThread);
            executorService.execute(foodieThread);
            executorService.execute(foodieThread);
        }
    }
}
