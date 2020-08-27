package com.etc.Ayy_exception;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * finally的作用:在代码出问题不出问题都会走到这里
 * try只会出现一次
 * catch可能会出现1-n次
 * finally 0-1次
 */
public class Exception_finally {
    public static void main(String[] args) {
        System.out.println("程序开始。。。。");
        try {
            parseDate("2013-03-23 10:19:23");
            System.out.println("功能成功执行！！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("功能执行失败！！");
        } finally {
            System.out.println("程序结束。。。。。");
//            用于在代码执行完毕后,进行资源回收,不建议在finally里面执行return语句
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
