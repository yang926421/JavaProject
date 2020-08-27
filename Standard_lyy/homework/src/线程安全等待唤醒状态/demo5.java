package 线程安全等待唤醒状态;

public class demo5 {
    /**
     描述在线程的生命周期中 有几种状态呢
     1.new()  新建,但并未启动
     2.Runnable  可运行
     线程在java虚拟机中的运行状态可能正在运行自己的代码也可能没有,这取决于操作系统处理器
     3.blocked 锁阻塞
     当一个线程试图去获取一个对象锁而该对象锁被其他线程持有,则该线程进入block状态,当该线程持有锁时,该线程将变成runnable状态
     4.Waiting(无限等待)
     一个线程在等待另一个线程执行一个(唤醒动作时),该线程进入waiting状态,进入这个线程是不能自动唤醒的,必须等待
     另一个线程执行notify或者notifyAll方法才能够被唤醒

     5.Time Waiting(计时等待)
     同waiting状态,有几个方法有超时参数.调用他们将进入Timed waiting状态
     6.被终止


     */
}
