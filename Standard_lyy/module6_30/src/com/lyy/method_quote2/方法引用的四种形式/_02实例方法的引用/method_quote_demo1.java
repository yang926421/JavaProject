package com.lyy.method_quote2.方法引用的四种形式._02实例方法的引用;

import java.util.ArrayList;
import java.util.List;

public class method_quote_demo1 {
    public static void main(String[] args) {
        /**
         方法引用:
         方法引用是为了进一步简化lambda表达式的写法
         2.实例方法的引用
         格式： 对象::实例方法。
         简化步骤：
         a.定义一个实例方法，把需要的代码放到实例方法中去。
         实例方法引用的注意事项
         ” 重要：被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致。“

         */
        List<String> names = new ArrayList<>();
        names.add("lyy");
        names.add("hht");
        names.add("lll1");

//        lambda表达式的终极写法
        names.forEach(s -> System.out.println(s));
        //方法引用的写法  前后都必须是相同参数  比如说都是s
        // 对象是 System.out = new PrintStream();
        // 实例方法：println()
        names.forEach(System.out::println);
    }
}
