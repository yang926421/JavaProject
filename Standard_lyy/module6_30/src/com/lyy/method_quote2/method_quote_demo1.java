package com.lyy.method_quote2;

import java.util.ArrayList;
import java.util.List;

public class method_quote_demo1 {
    public static void main(String[] args) {
        /**
         方法引用:
            方法引用是为了进一步简化lambda表达式的写法
            方法引用的格式,
                类型或者对象::引用的方法
         */
        List<String> names = new ArrayList<>();
        names.add("lyy");
        names.add("hht");
        names.add("lll1");

//        lambda表达式的终极写法
        names.forEach(s -> System.out.println(s));
        //方法引用的写法  前后都必须是相同参数  比如说都是s
        names.forEach(System.out::println);

    }
}
