package com.lyy._01lambda_l;
/**

    @ FunctionalInterface函数式接口注解
    一个接口加上了这个注解,这个接口只能有且只有一个抽象方法,就可以lambda简化


 */
public class lambda_demo2 {
    //继承runnable接口
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是匿名内部类的写法");
            }
        });
        t1.start();

        //lambda简化
        Thread t2 = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"在运行");
        });
        t2.start();
        //不用定义多态接这个对象直接start
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"在运行ya");
        }).start();
        //只有一行代码可以省略大括号
        new Thread(()-> System.out.println(Thread.currentThread().getName()+"在运行呢")).start();

    }

}
