package com.etc.Ayy_concurrency.thread.线程池;

import java.util.concurrent.*;

//callable做线程池的任务可以得到线程执行的结果
public class callable_pool {
    public static void main(String[] args) {
        //创建一个线程池,指定三个固定线程
        ExecutorService pools = Executors.newFixedThreadPool(3);
        Future<String> t1 = pools.submit(new myCallable(100));
        Future<String> t2 = pools.submit(new myCallable(200));
        Future<String> t3 = pools.submit(new myCallable(300));
        Future<String> t4 = pools.submit(new myCallable(400));

        //获取线程池执行的任务的结果
        try {
            String res1 = t1.get();
            String res2 = t2.get();
            String res3 = t3.get();
            String res4 = t4.get();
            System.out.println(res1);
            System.out.println(res2);
            System.out.println(res3);
            System.out.println(res4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class

myCallable implements Callable<String> {
    private int n;

    public myCallable(int n) {
        this.n = n;
    }

    //使用线程池计算1-100  1-200 1-300的和
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + "===>" + sum;
    }
}