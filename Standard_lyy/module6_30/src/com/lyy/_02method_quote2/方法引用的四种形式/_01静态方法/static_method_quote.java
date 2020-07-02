package com.lyy._02method_quote2.方法引用的四种形式._01静态方法;

import com.lyy._01lambda_l.简化comparator接口.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class static_method_quote {
    public static void main(String[] args) {
        List<student> list2 = new ArrayList<>();
        student s1 = new student("lyy", 23, '男' );
        student s2 = new student("hht", 24, '女' );
        student s3 = new student("lll", 21, '男' );
//        list2.add(s1);
//        list2.add(s2);
//        list2.add(s3);
        //简化写法
        Collections.addAll(list2, s1, s2, s3);

        //按照年龄进行升序排序
        Collections.sort(list2, new Comparator<student>() {
            @Override
            public int compare(student s1, student s2) {
                return s1.getAge() - s2.getAge();
            }
        });
        //简化排序的函数式接口的匿名内部类
        Collections.sort(list2, (student t1, student t2) ->{
            return t1.getAge() - t2.getAge();
        });
        //去掉return语句
        Collections.sort(list2, (student t1, student t2) -> t1.getAge() - t2.getAge());
        //再次简化, 去除参数类型
        Collections.sort(list2, ( o1,  o2)->  o1.getAge() - o2.getAge());
//        System.out.println(list2);
        //使用定义静态方法进行简化
//        Collections.sort(list2, ( o1,  o2)-> student.compareByAge(o1, o2));
        //如果前后参数是一样的,而且方法还是静态的,即可以使用静态方法
        Collections.sort(list2, student::compareByAge);
        System.out.println(list2);
    }
}
