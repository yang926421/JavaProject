package com.etc.Ayy_concurrency.thread.线程安全之同步方法.线程安全问题;

/**
 * 目标：线程同步_同步代码块
 * <p>
 * 线程同步的作用：就是为了解决线程安全问题的方案。
 * <p>
 * 线程同步解决线程安全问题的核心思想：
 * 让多个线程实现先后依次访问共享资源，这样就解决了安全问题。
 * 线程同步的做法：
 * 是把共享资源进行上锁，每次只能一个线程进入访问完毕以后，其他线程才能进来。
 * <p>
 * 线程同步的方式有三种：
 * （1）同步代码块。
 * （2）同步方法。
 * （3）lock显示锁。
 * <p>
 * b.同步方法
 * 作用：把出现线程安全问题的核心方法给锁起来，
 * 每次只能一个线程进入访问，其他线程必须在方法外面等待。
 * 用法：直接给方法加上一个修饰符 synchronized.
 * 原理:  同步方法的原理和同步代码块的底层原理其实是完全一样的，只是
 * 同步方法是把整个方法的代码都锁起来的。
 * 同步方法其实底层也是有锁对象的：
 * 如果方法是实例方法：同步方法默认用this作为的锁对象。
 * 如果方法是static静态方法：同步方法默认用类名.class作为的锁对象。
 */
public class Account {
    private String cardId;
    private double money;


    public Account() {

    }

    public Account(String cardId, double money) {
        this.money = money;
        this.cardId = cardId;

    }

    //只在这个方法处 加synchronized
    public void drawMoney(double money) {
        //开始判断取钱逻辑
        // 1.先知道是谁来取钱 加锁 此刻的锁对象可以是任意的唯一对象  可以是个简单字符串,但是不建议
        // 直接把this对象传进来  建议使用共享资源 在这个实例中  账户便是共享资源this
        synchronized (this) {
            String name = Thread.currentThread().getName();
            // 2.判断余额是否足够
            if (this.money >= money) {
                System.out.println(name + "来取钱，余额足够，吐出" + money);
                // 3.更新余额
                this.money -= money;
                System.out.println(name + "来取钱后，余额剩余" + this.money);
            } else {
                System.out.println(name + "来取钱，余额不足！");
            }
        }
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
