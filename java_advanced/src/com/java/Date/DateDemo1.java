package com.java.Date;
import java.text.DateFormat;
import java.util.Date;
/**
 构造器
    public Date(): 创建当前系统的此刻日期时间
    public Date(long time);  将传进来的时间毫秒值转换成为日期时间



 * */

public class DateDemo1 {

    public static void main(String[] args) {
        Date d1 = new Date();
//        //打印出人类可读的时间格式
//        System.out.println(d1);
//
//        long l1 = d1.getTime();
//        //时间戳,时间毫秒值
//        System.out.println(l1);
        //计算程序流程时间
//        long st = new Date().getTime();
//        for (int i=1; i< 100000; i++){
//            System.out.println("输出+"+i);
//        }
//        long e1 = new Date().getTime();
//        System.out.println((e1 - st)/1000.0);
        System.out.println(d1);
        //拿到此刻时间往后走121秒
        long time = d1.getTime() + 121*1000;
        Date d2 = new Date(time);
        System.out.println(d2);
        DateFormat
    }
}
