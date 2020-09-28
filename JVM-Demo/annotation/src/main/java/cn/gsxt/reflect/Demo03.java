package cn.gsxt.reflect;


import org.omg.SendingContext.RunTime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//分析性能问题
public class Demo03 {
    public void test01(){
        //普通方式调用
        User user = new User();
        Long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++){

        }

        //结束时间
        Long endTime = System.currentTimeMillis();
    }
    //反射方式调用


    //反射方式 关闭检测
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface lyy{

}