package com.etc.Ayy_concurrency.thread.调用父类有参构造器为线程创建名字;

public class thread_name {
    // public thread(){} 无参构造器
    //public thread(String name){}  有参构造器  通过子类super父类的构造器
    public static void main(String[] args) {
        Thread t1 = new MyThread("线程1");
        t1.start();
        Thread t2 = new MyThread("线程2");
        t2.start();
        for (int i =0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+"====>"+i);
        }

    }

}

class MyThread extends Thread{
    //有参构造器
    public MyThread(String name)
    //public thread(string name); 父类的有参构造器
    {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i<10;i++){
            System.out.println(Thread.currentThread().getName()+"===>"+i);
        }
    }
}
