package com.java.package_class;

public class package_class_demo2 {
    public static void main(String[] args) {
        // 包装类作为类首先继承了object类
        Integer i1 = 100;
//        转换成字符串
        String it = Integer.toString(i1);
        String it2 = i1.toString();
        System.out.println(it);
        System.out.println(it2);
        // 3直接+空字符串即可
        String it3 = it + "";


        // 把字符串数据类型的值转换成基本数据类型的值
        String numstr = "23";
        int num = Integer.parseInt(numstr);
        String DOUBLE_STR = "99.8";
        double dou = Double.parseDouble(DOUBLE_STR);
//        上面这两个已经被淘汰
        int num2 = Integer.valueOf(numstr);
        double dou2 = Double.valueOf(DOUBLE_STR);
        System.out.println(num2);
        System.out.println(dou2);


    }
}
