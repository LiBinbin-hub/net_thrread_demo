package com.practice.demos.threadDemo.practiceDemo;

import lombok.Data;

@Data
public class Account {

    private double money;

    public Account() {
    }

    Account(double money) {
        this.money = money;
    }

    //静态方法同步代码块
    public static void test() {
        synchronized (Account.class) {

        }
    }

    public void drawMoney(double money, String accountName) {
        System.out.println(accountName + "在取钱。。。。。");
        //同步代码块
        synchronized (this) {
            if (this.money >= money) {
                this.money = this.money - money;
                System.out.println(accountName + "取完钱后，账户还剩:" + this.money);
            } else {
                System.out.println(accountName + "来取钱，余额不足");
            }
        }
    }

    //同步方法(隐式的将当前对象实例作为锁)
    public synchronized void drawMoney1(double money, String accountName) {
        System.out.println(accountName + "在取钱。。。。。");
        if (this.money >= money) {
            this.money = this.money - money;
            System.out.println(accountName + "取完钱后，账户还剩:" + this.money);
        } else {
            System.out.println(accountName + "来取钱，余额不足");
        }
    }


}
