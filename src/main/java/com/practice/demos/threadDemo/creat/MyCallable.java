package com.practice.demos.threadDemo.creat;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Number> {
    @Override
    public Number call() {
        return 111111;
    }
}
