package com.etc.Ayy_concurrency.thread.线程创建方式2;

public class thread_demo2 {
//这个类是第二种方式的匿名写法
public static void main(String[] args) {
    //匿名写法
    Runnable target = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i<100;i++){
                System.out.println(Thread.currentThread().getName()+ i + "在执行");
            }
        }
    };
    Thread t2 = new Thread(target);
    t2.start();
    // 将匿名内部类当做target
    /**Thread t3 = new Thread( new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i<100;i++){
                System.out.println(Thread.currentThread().getName()+ i + "在执行");
            }
        }
    });*/
    //直接t2这一堆直接调start'
    /**new Thread( new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i<100;i++){
                System.out.println(Thread.currentThread().getName()+ i + "在执行");
            }
        }
    }).start();*/


    for (int i = 0; i<100;i++){
        System.out.println(Thread.currentThread().getName()+ i + "在执行");
    }
}
}


