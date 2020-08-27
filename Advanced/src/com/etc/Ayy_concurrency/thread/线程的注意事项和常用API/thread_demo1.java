package com.etc.Ayy_concurrency.thread.线程的注意事项和常用API;

public class thread_demo1 {
    /**
     * 注意事项
     * 线程的启动必须调用start方法,否则java会当成一个普通类来处理
     * 不能直接调用run方法,相当于调用了普通类的执行,此时只有主线程在执行他们
     * start()方法底层其实是给CPU注册当前线程,并触发run()方法,
     * 建议先创建子线程启动子线程 把主线程代码放在子线程注册之后  子线程和主线程才会公平竞争,否则主线程永远先执行完
     * <p>
     * <p>
     * <p>
     * 方法
     * 1.getName() 获取线程的名字
     * 2.setName()  设置线程的名字
     * 3.Thread m = Thread.currentThread()   //获取主线程的对象  这个代码在哪个线程中,就得到哪个线程对象
     * thread.sleep(1000) 让当前线程休眠一秒
     */
    public static void main(String[] args) {
        // 启动后thread_demo1会当做一个进程
        //main方法会由主线程执行
        //3.创建一个线程对象
        Thread t1 = new My_thread();
//        //如果直接调run方法,相当于变成了一个普通类来执行,
//        t1.run();  //无论什么情况  都将先打印子线程
        t1.start();
        Thread t2 = new My_thread();
        t2.start();
        t1.setName("1号线程");
        t2.setName("2号线程");
        System.out.println(t1.getName());  //获取子线程的名字

        //主线程的名字的获取
        Thread m = Thread.currentThread();
        System.out.println(m.getName());
        m.setName("我是主线程呀");
        for (int i = 0; i < 10; i++) {
            System.out.println(m.getName() + i);
        }

    }
}

//1 创建一个线程类,是一个类不是一个线程对象
class My_thread extends Thread {
    //2 重写run方法
    @Override
    public void run() {
        // 线程的执行方法。
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);// 让当前线程休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i + "在执行");
        }
    }
}
