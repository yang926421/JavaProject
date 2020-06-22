package com.etc.Ayy_exception;

import javax.security.auth.login.FailedLoginException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception编译异常处理 {
    /**
     * // 抛异常的方式
        // 1.单个异常每个都抛2.Exception 所有异常
    // throw Exception  可以接受所有异常,不用每一个异常都抛出来,但是这种抛异常还是会把所有异常
    // 都会抛出给虚拟机,谁都不会处理.然后虚拟机就会打印出堆栈错误,没啥意思,程序还是会挂

    // 方式二
        //在出现异常的时候自己处理,捕获异常
       try{
        可能会出现异常的代码
     }
     catch(){

     }
     catch(){

     }
    */
    //第一种方式
    /**
     public static void main(String[] args) throws Exception{
     String date = "2015-01-12 10:23:21";
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date d = sdf.parse(date);
     System.out.println(d);

     }

     */
    public static void main(String[] args) {
        try{
            String date = "2015-01-12 10:23:21";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = sdf.parse(date);
            System.out.println(d);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }


        // 第三种 打印异常栈信息
        try{
            String date = "2015-01-12 10:23:21";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = sdf.parse(date);
            System.out.println(d);
        }
        //每一个异常都捕获一下
        catch (ParseException e){
            e.printStackTrace();// 打印异常栈信息
        }
//        catch (FailedLoginException e){
//            e.printStackTrace();// 打印异常栈信息
//        }
//        JDK1.7之后  可以一行写多个异常
//        catch(ParseException|另一个异常信息 e){
//            e.printStackTrace();// 打印异常栈信息
//        }
        //公司常用写法
//        catch(Exception e){
//            e.printStackTrace();
//        }

    }
}
