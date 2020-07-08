package 面向对象相关._04常用API集合泛型._01Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_demo5 {
    public static void main(String[] args) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2016-12-18");
        //修改日期模式
        sdf.applyPattern("yyyy年MM月dd日");
        String newStr = sdf.format(date);
        System.out.println(newStr);



    }
}
