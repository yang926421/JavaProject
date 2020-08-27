package com.etc.Ayy_concurrency.thread.线程安全之lock锁;


public class draw_thread extends Thread {
    //定义一个成员变量接收账户信息
    private Account acc;

    //有参构造器
    public draw_thread(Account acc, String name) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        //小红小明来取钱
        acc.drawmoney(100000);
    }
}
