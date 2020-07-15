package 面向对象相关._04常用API集合泛型._01Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_demo {
    public static void main(String[] args) {
        Date D1 = new Date();
        System.out.println(D1.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(D1.getTime()));
    }
}
