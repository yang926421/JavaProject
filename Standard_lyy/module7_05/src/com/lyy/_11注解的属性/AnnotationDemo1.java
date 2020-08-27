package com.lyy._11注解的属性;

/**
 * 属性的格式
 * 格式一  数据类型  属性名();
 * 格式二  数据类型   属性名（） default 默认值；
 * <p>
 * 属性适用的八种数据类型（
 * byte int float long double
 * boolean short char
 * ）
 * 小结
 * 注解可以有属性，属性名必须带()
 * 在使用注解的时候，属性必须赋值，除非这个属性有默认值
 */
@MyBook(name = "<<精通Java基础>>", authors = {"波仔", "lyy"}, price = 99.2)
public class AnnotationDemo1 {

    @MyBook(name = "<<mysql从入门到跑路>>", authors = {"fei仔", "lyy"}, price = 1010.2)
    public static void main(String[] args) {

    }

}

@interface MyBook {
    String name();

    String[] authors(); //数组

    double price();

    String address() default "广州";
}
