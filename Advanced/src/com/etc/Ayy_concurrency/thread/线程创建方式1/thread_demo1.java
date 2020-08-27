package com.etc.Ayy_concurrency.thread.线程创建方式1;

/**
 * 进程的三个特征
 * 1.动态性  进程是运行中的程序,要动态的占用内存,CPU和网络资源
 * 2.独立性: 进程与进程之间是相互独立的,彼此有自己的独立内存区域
 * 3.并发性,假如CPU是单核,同一时刻中内存中只有一个进程在被执行,CPU会分时轮询依次为每个进程服务,因为切换的时候非常快,给我
 * 门的感觉像是在同时执行,这就是并发性
 * <p>
 * 并行  同一时刻同时有多个在执行
 * <p>
 * 什么是线程?
 * 线程是进程的一个独立执行单元,一个进程包含多个线程,这就是多线程,线程创建开销比进程小
 * 线程的作用：
 * 可以提高程序的效率，线程也支持并发性，可以有更多机会得到CPU。
 * 多线程可以解决很多业务模型。
 * 大型高并发技术的核心技术。
 * 设计到多线程的开发可能都比较难理解。
 * 线程的创建方式
 */
public class thread_demo1 {

    public static void main(String[] args) {
        // 启动后thread_demo1会当做一个进程
        //main方法会由主线程执行
        //3.创建一个线程对象
        Thread t1 = new My_thread();
        //启动线程对象
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程输出：" + i);
        }

    }
}

//1 创建一个线程类,是一个类不是一个线程对象
class My_thread extends Thread {
    //2 重写run方法
    @Override
    public void run() {
        // 线程的执行方法。
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程输出：" + i);
        }
    }
}
