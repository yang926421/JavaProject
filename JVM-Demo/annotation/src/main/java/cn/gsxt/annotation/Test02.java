package cn.gsxt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test02 {

    @myAnnotation(value = "lyy", id = 2)
    public void test(){

    }
}


//自定义注解

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation{
    //不是一个方法,是一个参数
    String value();

    //定义有默认值的注解
    int id() default -1;
}