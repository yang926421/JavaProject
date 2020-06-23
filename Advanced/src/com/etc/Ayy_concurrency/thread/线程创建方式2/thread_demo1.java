package com.etc.Ayy_concurrency.thread.线程创建方式2;

/**
 Thread的构造器
    public Thread(){}
    public Thread(String name){}
    public Thread(Runnable target()){}
         Runnable target = new MyRunnable();
         // 不是线程对象 所以不能直接start()
         //把线程任务对象包装成线程对象
         Thread t1 = new Thread(target);
    public Thread(Runnable target, String name){}
 实现Runnable接口创建线程的优缺点
 缺点:  代码复杂了一点
 优点 Runnable实现了接口,可以实现多接口,还可以再继承类
    同一个线程任务对象可以被包装成多个线程对象  线程任务对象可以只写一次,但是线程对象可以
 根据线程任务多次设置
    适合多个相同的程序代码去共享同一个资源
    增加程序的健壮性,实现解耦操作,可以被多个线程共享
 线程池可以放入实现Runnable或callable线程任务对象
    Thread类本质上也是实现了Runnable接口


 */
public class thread_demo1 {
    public static void main(String[] args) {
        //3.创建线程任务对象  线程任务对象不是线程对象,只是执行线程的任务的
        Runnable target = new MyRunnable();
        // 不是线程对象 所以不能直接start()
        //把线程任务对象包装成线程对象
        Thread t1 = new Thread(target);
        //天然支持创建有参线程对象
        Thread t2 = new Thread(target, "线程2");
        t1.start();
        t2.start();
        for (int i =0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+"====>"+i);
        }
    }

}
    //第一种方式是继承Thread类
//第二种方式
// 1创建一个线程任务类实现Runnable接口
class MyRunnable implements Runnable{
    //2重写run方法
        @Override
        public void run() {
            for (int i =0; i<10; i++){
                System.out.println(Thread.currentThread().getName()+"====>"+i);
            }
        }
    }
