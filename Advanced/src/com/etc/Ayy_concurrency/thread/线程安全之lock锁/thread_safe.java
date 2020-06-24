package com.etc.Ayy_concurrency.thread.线程安全之lock锁;
/**
 c.lock显示锁。
 java.util.concurrent.locks.Lock机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作,
 同步代码块/同步方法具有的功能Lock都有,除此之外更强大

 Lock锁也称同步锁，加锁与释放锁方法化了，如下：
 - `public void lock() `:加同步锁。
 - `public void unlock()`:释放同步锁。

 总结：
 线程安全，性能差。
 线程不安全性能好。假如开发中不会存在多线程安全问题，建议使用线程不安全的设计类。
 */

public class thread_safe {
    public static void main(String[] args) {
        // a.创建一个账户对象。
        Account acc = new Account("dddd", 100000);
        // b.定义一个线程类创建2个线程代表小明和小红
        Thread xiaoMing = new draw_thread(acc , "小明");
        xiaoMing.start();

        Thread xiaoRed = new draw_thread(acc, "小红");
        xiaoRed.start();

    }
}
