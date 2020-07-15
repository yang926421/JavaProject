package com.lyy.mysql3.ThreadLocal;

public class threadLocalDemo01 {
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();
        //获取当前线程对象(main线程)上绑定的值
        String str = tl.get();
        System.out.println(str);

    }
}
