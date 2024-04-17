package com.practice.demos.threadDemo.practiceDemo.threadPoll;

import com.practice.demos.threadDemo.creat.MyCallable;
import com.practice.demos.threadDemo.creat.MyRunnable;

import java.util.concurrent.*;

// 线程池拒绝策略： 1. 抛异常；2 ：丢弃；
// 3：丢弃等待时间最久的任务并将来新任务加入； 4：绕过线程池主线程调用run()方法执行该任务
//临时线程创建时机：核心线程都处于忙， 任务队列满的情况
//创建线程池的两种方法：threadPoolExecutor, 调用ThreadPoolExecutor静态方法创建
public class PoolMain {
    public static void main(String[] args) {
        //核心线程数量， 最大线程数量， 临时线程存活时间， 存活时间单位， 任务队列， 线程工厂， 任务拒绝策略
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(3, 5
                , 8, TimeUnit.SECONDS
                , new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //线程池执行Runnable线程任务
        MyRunnable myRunnable = new MyRunnable();
        threadPoolExecutor.execute(myRunnable);

        //线程池执行Callable线程任务
        try {
            Future<Number> submit = threadPoolExecutor.submit(new MyCallable());
            Number number = submit.get();
            System.out.println(number);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
