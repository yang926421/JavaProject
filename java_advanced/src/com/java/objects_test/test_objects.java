package com.java.objects_test;
import java.util.Objects;
import java.util.Date;
/**
 *
 *
 * 源码中的书写方法
 public static boolean equals(Object a, Object b) {
 return (a == b) || (a != null && a.equals(b));
 }
 * */

public class test_objects {

    public static void main(String[] args) {
        student s1 = new student();
        student s2 = new student();
        System.out.println(s1.equals(s2));
        System.out.println(Objects.equals(s1, s2));
        System.out.println(Objects.isNull(s1));
    }
}
