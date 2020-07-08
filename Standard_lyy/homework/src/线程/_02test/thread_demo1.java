package 线程._02test;

public class thread_demo1 {
    /**
     描述创建线程的三种方式
     定义类继承Thread线程类
     重写run方法
    创建子类的对象,并调用start()方法  启动

     Runnable
        定义runnable的子类
        重写run方法
     创建runnable的线程任务对象,包装成线程对象
     Runnable target = new myRunnable();
     Thread t1 = new Thread(target)
     调用start启动线程


     callable
        callable不同之处在于,可以返回线程执行的结果
     定义类继承callable,创建线程任务类对象 未来任务对象包装callable对象,未来任务对象继承callable
     所以将未来任务对象包装成Thread线程对象  启动




















     */
}
