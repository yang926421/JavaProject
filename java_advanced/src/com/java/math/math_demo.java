package com.java.math;

/**
 * Math用作数学运算
 * Math类中的方法全部是静态方法,直接类名调用
 * 常用的五个方法
 * public static int abs(int a)  获取参数a的绝对值
 * public static double ceil(double a) 向上取整
 * public static double floor(double a) 向下取整
 * public static double pow(double a, double b) 获取a的b次幂
 * public static long round(double a)        四舍五入取整数
 */
public class math_demo {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(Math.abs(10));
        System.out.println(Math.ceil(4.4444)); //5
        System.out.println(Math.floor(4.44)); //4
        System.out.println(Math.pow(2, 3)); //8
        System.out.println(Math.round(4.444)); //4
        System.out.println(Math.round(4.544)); //5

    }
}
