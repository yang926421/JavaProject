package 面向对象相关._04常用API集合泛型._01Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_demo3 {
    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime() + (5 * 24 * 60 * 60 * 1000);
        Date date2 = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date2));
//        date.getTime() += 500*24*60*60*1000;

    }
}
