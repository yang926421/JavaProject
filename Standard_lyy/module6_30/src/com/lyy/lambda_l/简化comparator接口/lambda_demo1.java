package com.lyy.lambda_l.简化comparator接口;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * lambda表达式的省略写法
 * 1.如果方法体只有一行代码,大括号可省略,把代码放一行
 * 2.如果方法体中只有一行代码且代码是return 语句, return也可以不写
 * 3.参数类型可以省略不写
 * 4.如果只有一个参数.参数类型可以省略,同时()也可以省略
 *
 * */
public class lambda_demo1 {
    public static void main(String[] args) {
        List<student> list1 = new ArrayList<>();
        student s1 = new student("lyy", 23, '男' );
        student s2 = new student("hht", 24, '女' );
        student s3 = new student("lll", 21, '男' );
//        list1.add(s1);
//        list1.add(s2);
//        list1.add(s3);
        //简化写法
        Collections.addAll(list1, s1, s2, s3);

        //按照年龄进行升序排序
        Collections.sort(list1, new Comparator<student>() {
            @Override
            public int compare(student s1, student s2) {
                return s1.getAge() - s2.getAge();
            }
        });
        //简化排序的函数式接口的匿名内部类
        Collections.sort(list1, (student t1, student t2) ->{
            return t1.getAge() - t2.getAge();
        });
        //去掉return语句
        Collections.sort(list1, (student t1, student t2) -> t1.getAge() - t2.getAge());
        //再次简化, 去除参数类型
        Collections.sort(list1, ( o1,  o2)->  o1.getAge() - o2.getAge());
        System.out.println(list1);
    }
}
