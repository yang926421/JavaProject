package com.etc.Ayy_concurrency.变量原子性并发包.原子性;
/**
 原子性
    保证原子性操作的方案一
        加锁(性能较差)
 */

class VolatileAtomicThread1 implements Runnable {
    // 定义一个int类型的遍历
    private int count = 0 ;
    @Override
    public void run() {
        // 对该变量进行++操作，100次
        synchronized ("lyy"){
        for(int x = 0 ; x < 100 ; x++) {
            count++ ;
            System.out.println("count =========>>>> " + count);
        }}
    }
}

public class atom_demo2 {
    public static void main(String[] args) {
        // 创建VolatileAtomicThread对象
        Runnable target = new VolatileAtomicThread1() ;
        // 开启100个线程对执行这一个任务。
        for(int x = 0 ; x < 100 ; x++) {
            new Thread(target).start();
        }
    }


}