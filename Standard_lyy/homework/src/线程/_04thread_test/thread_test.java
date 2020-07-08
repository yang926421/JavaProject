package 线程._04thread_test;

public class thread_test {
    public static void main(String[] args) {
        Thread t1 =  new CountThread(10);
        Thread t2 = new CountThread(6);
        Thread t3 = new CountThread(4);
        t1.start();
        t2.start();
        t3.start();
    }
}

class CountThread extends Thread{
    private int num;
    public CountThread(int num){
        this.num = num;

    }
    @Override
    public void run() {
        int sum = 1;
        //计算阶乘
        for(int index =  num;index>=1; index--){
            sum*=index;
        }
        System.out.println(Thread.currentThread().getName()+"的值"+num+"的阶乘和为"+sum);
    }
}
