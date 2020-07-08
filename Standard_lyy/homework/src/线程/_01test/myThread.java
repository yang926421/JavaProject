package 线程._01test;

import java.util.Random;

public class myThread extends Thread {
    @Override
    public void run() {
        //定义求和变量
        int sum =0;
        //创建随机对象
        Random ran = new Random();
        for(int i=0; i<1000;i++){
            sum+=(ran.nextInt(901)+100);
        }
        System.out.println(sum);

    }
}
