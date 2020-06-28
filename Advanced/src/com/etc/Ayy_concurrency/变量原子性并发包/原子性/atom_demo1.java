package com.etc.Ayy_concurrency.变量原子性并发包.原子性;
/**
 原子性
    指一次操作中,一批操作会看做一个整体,要么同时成功,要么同时失败,不能被干扰
 volatile只能保证线程间变量的可见性,不能保证变量操作的原子性,原子性类似于数据库的事务
 */

class VolatileAtomicThread implements Runnable {
    // 定义一个int类型的遍历
    private volatile int count = 0 ;
    @Override
    public void run() {
        // 对该变量进行++操作，100次
        for(int x = 0 ; x < 100 ; x++) {
            count++ ;
            System.out.println("count =========>>>> " + count);
        }
    }
}

public class atom_demo1 {
    public static void main(String[] args) {
        // 创建VolatileAtomicThread对象
        Runnable target = new VolatileAtomicThread() ;
        // 开启100个线程对执行这一个任务。
        for(int x = 0 ; x < 100 ; x++) {
            new Thread(target).start();
        }
    }


}