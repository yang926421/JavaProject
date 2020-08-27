package com.lyy._06递归;

public class recursion_demo2 {
    /**
     * 递归的三要素
     * 递归的终结点
     * 递归的公式
     * 递归的方向  必须走向终结点
     */
    public static void main(String[] args) {
        System.out.println(fun(10));


    }

    public static int fun(int x) {
        if (x == 1) {
            return 1;
        } else {
            return fun(x - 1) + 1;
        }
    }
}
