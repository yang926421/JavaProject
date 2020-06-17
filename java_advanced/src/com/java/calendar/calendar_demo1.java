package com.java.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 Calendar 代表了系统此刻日期对应的日历对象
 Calendar 是一个抽象类,不能直接创建对象
 Calendar 创建日历对象的语法
    Calendar  right_now = Calendar.getInstance();
 Calendar的方法
    public static Calendar getInstance(); 返回一个日期类对象
    public int get (int field); 取日期中某个字段的信息
    public void set(int field, int value); 修改某个字段的信息为value值
    public void add(int field, amount); 为某个字段增加减少指定的值
    public final Date getTime();  拿到此刻时间的对象
    public long getTimeInMillis();  拿到此刻时间对应的毫秒值
 */


public class calendar_demo1 {
    //Calendar
    public static void main(String[] args) {
        // 通过调用日历类的静态方法getInstance得到一个当前此刻日期对象对应的日历对象
        Calendar right_now = Calendar.getInstance();
        System.out.println(right_now);
        //1 获取年
        int year = right_now.get(Calendar.YEAR);
        //2 获取月
        int mm = right_now.get(Calendar.MONTH) + 1;
        //3 获取一年中的哪一天
        int dd = right_now.get(Calendar.DAY_OF_YEAR);
        //4 修改日历的信息
        right_now.set(Calendar.YEAR, 2099);
        System.out.println(right_now.get(Calendar.YEAR));
        //5 日历可以得到此刻日期对象  是先拿到日历对象 再拿日期对象 比较鸡肋
        Date d = right_now.getTime();
        // 得到此刻的日期对象
        System.out.println(d);
        // 6 时间毫秒值   通过日历来拿 提供这个API接口  我们可以不用
        long time = right_now.getTimeInMillis();
        System.out.println(time);
        // 日历向后走多少天的日期对象
        right_now.add(Calendar.DAY_OF_YEAR, 701);
        System.out.println(right_now);
        // 向日历后走多少时分秒
        right_now.add(Calendar.HOUR, 45);
        right_now.add(Calendar.MINUTE, 45);
        right_now.add(Calendar.SECOND, 45);
        //拿到向前的日历对象  只需要把时间值改为负即可

    }

}
