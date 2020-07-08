package 线程安全等待唤醒状态;

/**
 请按要求编写多线程应用程序，模拟多个人通过一个山洞：

 - 这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒。
 - 随机生成10个人，同时准备过此山洞，显示每次通过山洞人的姓名。


 */
public class demo1 {
    public static void main(String[] args) {
     for(int i= 0; i <10; i++){
         Thread t1 = new GuoShanDong("LYY"+i);
         t1.start();
     }
    }
}

class GuoShanDong extends Thread{
    //定义通过隧道的人数
    private static int count;
    public GuoShanDong(String name){
        super(name);

    }
    @Override
    public void run() {
        synchronized (GuoShanDong.class){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count +=1;
            System.out.println(Thread.currentThread().getName()+"通过了隧道,他是第"+count+"人");

        }

    }
}
