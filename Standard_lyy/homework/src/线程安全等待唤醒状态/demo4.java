package 线程安全等待唤醒状态;

import 线程._01test.myThread;

import java.util.Random;

/**
 * 写一个卖票的程序，
 * <p>
 * 1. 写一个类，该类继承Thread，定义一个变量记录总票数。
 * <p>
 * 1. 开启四个卖票窗口(开始四个线程),同时执行卖票的程序。
 * 要求每卖一张票在控制台输出：当前窗口为：窗口a卖了一张票，剩余票数为19。其中窗口a为线程的名字。
 */
public class demo4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(new MyRunnable());
        Thread t4 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class MyRunnable implements Runnable {
    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (count > 0) {
                    count -= 1;
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + (100 - count) + "剩余" + count);
                }
            }
        }
    }
}
