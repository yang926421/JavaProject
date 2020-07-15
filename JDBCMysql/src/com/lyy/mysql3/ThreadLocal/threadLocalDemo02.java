package com.lyy.mysql3.ThreadLocal;

public class threadLocalDemo02 extends Thread{
    @Override
    public void run() {
        super.run();
    }
}
/**

 public void set(T value):给当前线程对象绑定一个T类型的值value
 什么叫做当前线程对象呢
 set方法在哪个线程中运行,哪个线程就是当前线程
 */