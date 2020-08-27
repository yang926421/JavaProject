package com.etc.Ayy_concurrency.thread.死锁的基本概念和必然死锁;

public class thread_dead {
    /**
     * 死锁是这样的一种情形,多个线程同时被阻塞,他们中的一个或多个都在等待某个资源的释放,由于线程被无限期阻塞
     * ,因此程序不可能被正常终止
     * 可以理解为  客户(占用资金,等待经销商的货品资源)   经销商(占用货品资源,等待资金)
     * 俩人都不释放,就死锁了
     * java死锁的四个必要条件
     * 1.互斥使用,即当资源被一个线程使用(占用时),别的资源不能适应
     * 2.不可抢占.请求者不能直接抢占有者
     * 3.请求和保持   即当资源请求者在请求其他资源的时候保持对原有资源的占有
     * 4.循环等待  存在一个等待循环队列  P1要P2的资源 p2要P1的资源
     * <p>
     * 小结
     * 死锁的代码实现通常要进行锁的嵌套访问
     */

//代码实现一个必然死锁
    //定义两个静态资源
    public static Object resources01 = new Object();
    public static Object resources02 = new Object();

    public static void main(String[] args) {

        //定义两个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resources01) {
                    System.out.println("线程1占有资源1,请求资源2");
                    try {
                        Thread.sleep(1000);   //sleep的时候会占有线程 不释放
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (resources02) {
                        System.out.println("线程1成功占有资源2");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resources02) {
                    System.out.println("线程2占有资源2,请求资源1");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (resources01) {
                        System.out.println("线程2成功占有资源1");
                    }
                }
            }
        }).start();
    }


}

