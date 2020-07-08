package 面向对象相关._04常用API集合泛型._02日期类;

import java.util.Calendar;

public class calendar_demo {
    public static void main(String[] args) {
        //获取当前日期时间对象
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 500);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
    }
}
