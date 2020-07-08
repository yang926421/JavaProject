package 线程._01test;

import 线程._01test.myThread;

public class test {
    public static void main(String[] args) {
        Thread t1 =  new myThread();
        t1.start();
    }
}
