package com.lyy._02method_quote2.方法引用的四种形式._04构造器方法引用;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
// 前后参数一致,又在创建对象就可以使用构造器引用
/**
 4.构造器引用。
 格式是：类名::new。
 注意点：前后参数一致的情况下，又在创建对象就可以使用构造器引用
 s -> new Student(s) => Student::new

 小结：
 方法引用是可遇不可求，能用则用，不能用就不要用！
 */
public class method_demo1 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("java1");
        lists.add("java2");
        lists.add("java3");

        //集合默认只能转化成object类型的数组
        Object[] objects = lists.toArray();
        System.out.println("object类型的数组:"+ Arrays.toString(objects));
        // 需求 想转化成字符串类型的数组
        //toarray提供的API 匿名内部类对象
        String[] str1 = lists.toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[0];
            }
        });
        //简化
        String[] str2 = lists.toArray(s -> new String[s]);
        // 构造器引用
        String[] str3 = lists.toArray(String[]::new);
        System.out.println(Arrays.toString(str3));

    }
}
