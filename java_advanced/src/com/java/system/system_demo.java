package com.java.system;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 System 类 代表当前系统
 System.exit(0)    终止jvm虚拟机  非0是异常终止
 System.currentTimeMillis() 获取当前系统时刻的毫秒值
 public static native void arraycopy(Object src,  int  srcPos,
 Object dest, int destPos,int length);
 1.原数组  2 从原数组哪个位置可以开始赋值  3目标数组  4 赋值到目标数组哪个位置 5 赋值几个

 */



public class system_demo {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();//获取当前系统时间毫秒值
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(time));
        int[] arr1 = new int[]{10, 20,30,40,50,60};
        int[] arr2 = new int[6];  // [0,0,0,0,0,0]
        System.arraycopy(arr1, 2, arr2, 0, 3);
        System.out.println(Arrays.toString(arr2));
    }
}
