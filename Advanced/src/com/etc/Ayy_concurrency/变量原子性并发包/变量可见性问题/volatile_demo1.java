package com.etc.Ayy_concurrency.变量原子性并发包.变量可见性问题;

/**
 * 多个线程访问共享变量,会出现一个线程修改变量的值后,其他线程看不见最新值的情况
 * 并发编程下  多线程修改变量,
 */
public class volatile_demo1 {
    public static void main(String[] args) {
        //启动线程 将线程中的对象的flag修改为true
        myThread thread1 = new myThread();
        thread1.start();
        //定义一个死循环
        while (true) {
            //这里读取到的flag一直是false.虽然线程已经把它的值改为true
            if (thread1.isFlag()) {
                System.out.println("执行了循环一次~~~");
            }
        }
    }
}

class myThread extends Thread {
    private boolean flag = false;

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
        System.out.println("线程修改了flag=" + flag);
    }
}

class myRunnable implements Runnable {
    @Override
    public void run() {

    }
}