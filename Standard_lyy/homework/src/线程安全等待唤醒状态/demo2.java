package 线程安全等待唤醒状态;

import javax.xml.namespace.QName;

public class demo2 {
    public static void main(String[] args) {
        Thread t1 = new Mythread("网上");
        Thread t2 = new Mythread("线下");
        t1.start();
        t2.start();

    }
}


class Mythread extends Thread{
    private int count = 100;
    private int saleCount;
    public Mythread(String name){
        super(name);
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        while(true){
            synchronized (this){
            if(count>0){
                count --;
                saleCount += 1;
                System.out.println(name+"卖出了");
            }
            else {
                break;
            }
        }}

    }
}