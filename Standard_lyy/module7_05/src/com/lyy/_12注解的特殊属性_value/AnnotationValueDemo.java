package com.lyy._12注解的特殊属性_value;

/**
 * 注解的特殊属性名称  value
 * value属性，如果只有一个value属性，，可以省略value不写
 * 如果有多个属性，且多个属性没默认值  则不能省略value
 */
public class AnnotationValueDemo {
    //后期遇到这个 可能会是别人写好的注解  意思是删除书籍操作
    @Book("/deleteBook.action")
    public static void main(String[] args) {

    }
}

@interface Book {
    String value();

    int age() default 10;
}
