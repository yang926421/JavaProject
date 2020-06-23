package com.etc.Ayy_exception;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception异常处理进阶 {
    public static void main(String[] args) {
        System.out.println("程序开始。。。。");
        try {
            parseDate("2013-03-23 10:19:23");  //可能会有异常, 内部抛出,在这里接这个异常
            System.out.println("功能成功执行！！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("功能执行失败！！");
        }
        finally {
            System.out.println("程序结束。。。。。");
        }

    }

    // 可以拦截所以异常!
    public static void parseDate(String time) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(time);
        System.out.println(d);

        InputStream is = new FileInputStream("D:/meinv.png");
    }
}
