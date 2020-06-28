package com.etc.Ayy_concurrency.变量原子性并发包.变量不可见性的解决;

/**
 * 变量不可见性的解决办法
 *   1 加锁
 *      //加锁  线程修改变量就可以获取到
 *                 /**
 *                  1）加锁：可以实现其他线程对变量修改的可见性。
 *                  某一个线程进入synchronized代码块前后，执行过程入如下：
 *                  a.线程获得锁
 *                  b.清空工作内存,读取最新值
 *                  c.从主内存拷贝共享变量最新的值到工作内存成为副本
 *   2 关键字 volatile
 *      定义变量的时候加volatile修饰  线程一旦修改,其他线程便能获取到最新值,会告诉其它线程之前获取的值原始值已经失效
 *      ,要去主内存中重新加载
 *      可以给成员变量加上一个volatile关键字，当一个线程修改了这个成员变量的值，其他线程可以立即看到修改后的值并使用！
 *          volatile与synchronized的区别。
 *          - volatile只能修饰实例变量和静态变量，而synchronized可以修饰方法，以及代码块。
 *          - volatile保证数据的可见性，但是不保证原子性(多线程进行写操作，不保证线程安全);
 *           而synchronized是一种排他（互斥）的机制，
 *  */

public class volatile_demo1 {
        public static void main(String[] args) {
            //启动线程 将线程中的对象的flag修改为true
            myThread thread1 = new myThread();
            thread1.start();
            //定义一个死循环
            while (true){
                //加锁  线程修改变量就可以获取到
                /**
                 1）加锁：可以实现其他线程对变量修改的可见性。
                 某一个线程进入synchronized代码块前后，执行过程入如下：
                 a.线程获得锁
                 b.清空工作内存
                 c.从主内存拷贝共享变量最新的值到工作内存成为副本*/
//                synchronized (volatile_demo1.class){
                if(thread1.isFlag()){
                    System.out.println("执行了循环一次~~~");
                }
//                }
            }
        }
    }

class myThread extends Thread{
        private volatile boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //将flag的值更改为true
            this.flag = true;
            System.out.println("线程修改了flag="+flag);
        }
    }

