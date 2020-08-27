package 面向对象相关._04常用API集合泛型._01Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_demo2 {
    public static void main(String[] args) throws Exception {
        Date D1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1995-05-15");
        System.out.println(date);

    }
}
