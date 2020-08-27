package com.etc.Ayy_concurrency.thread.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池在java中的代表类  ExecutorService(接口)
 * java在Executors类下提供了一个静态方法newFixedThreadPool得到一个线程池对象,返回值类型为
 * ExecutorService
 */

public class thread_pool_demo2 {
    public static void main(String[] args) {
        //创建一个线程池,指定三个固定线程
        ExecutorService pools = Executors.newFixedThreadPool(3);
        Runnable target = new myRunnable();
        //添加任务 让线程池处理
        pools.submit(target);//第一次提交任务,此时线程池创建新线程
        pools.submit(target);//第2次提交任务,此时线程池创建新线程
        pools.submit(target);//第3次提交任务,此时线程池创建新线程
        pools.submit(target);//第4次提交任务 等待使用之前的线程

        pools.shutdown();  //等任务执行完毕后关闭线程池
        pools.shutdownNow(); //立即关闭  任务可能还没执行完毕


    }
}

class myRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);
        }
    }
}