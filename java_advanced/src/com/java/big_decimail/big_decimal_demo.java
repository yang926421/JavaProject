package com.java.big_decimail;

import java.math.BigDecimal;

public class big_decimal_demo {
    public static void main(String[] args) {
        //浮点型数据直接运算会出现精度丢失问题
        double b = 0.1;
        double a = 0.2;
//        BigDecimal类创建对象的方式
        BigDecimal b1 = BigDecimal.valueOf(a); //包装浮点数成为大数据对象
        BigDecimal a1 = BigDecimal.valueOf(b);
        BigDecimal C1 = a1.add(b1);  //a1+b1
        System.out.println(C1);
        BigDecimal c1 = a1.subtract(b1); //a1-b1
        BigDecimal c2 = a1.multiply(b1);  //a1*b1
        BigDecimal C3 = a1.divide(b1);  //  a1 / b1
        System.out.println(C3);

        // BigDecimal 只能解决精度丢失的问题,但是浮点型数据最后才是我们想要的
        double rs = c1.doubleValue();  //转换成double类型的API

        }
}
