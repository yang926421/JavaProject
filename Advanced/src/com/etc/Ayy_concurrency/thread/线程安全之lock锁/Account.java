package com.etc.Ayy_concurrency.thread.线程安全之lock锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String cardID;
    private double money;  //余额
    //创建一把唯一的锁
    private final Lock lock = new ReentrantLock();

    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    //取钱操作
    public void drawmoney(double money) {
        String name = Thread.currentThread().getName();
        lock.lock();
        try {
            if (this.money >= money) {
                // 3.余额足够
                System.out.println(name + "来取钱，吐出：" + money);
                // 4.更新余额
                this.money -= money;
                // 5.输出结果
                System.out.println(name + "来取钱" + money + "成功，取钱后剩余：" + this.money);
            } else {
                // 6.余额不足
                System.out.println(name + "来取钱，余额不足，剩余" + this.money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
