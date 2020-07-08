package 面向对象相关._04常用API集合泛型._01Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_demo4 {
    public static void main(String[] args) throws Exception{
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //解析生日时间戳
        long bir_time = sdf.parse("1995-05-15").getTime();
        //获取现在的时间戳
        long now_time = System.currentTimeMillis();
        long liveTime = now_time - bir_time;
        long dates = liveTime/(1000*60*60*24);
        System.out.println(9186/356);
        System.out.println("从我出生到现在"+dates);


    }
}
