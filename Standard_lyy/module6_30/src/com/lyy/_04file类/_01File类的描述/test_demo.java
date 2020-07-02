package com.lyy._04file类._01File类的描述;

import java.io.File;

public class test_demo {
    public static void main(String[] args) {
        File f1 = new File("D:\\lyy\\documents\\project1\\Standard_lyy\\module6_30\\src\\com\\lyy\\_04file类\\_01File类的描述\\file_demo1.java");
        System.out.println(f1.length());
        System.out.println(f1.exists());
        File f2 = new File("D:\\lyy\\documents\\爬虫\\picture\\meinv1.jpg");
        System.out.println(f2.exists());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getName());
        System.out.println(f2.getPath());

        //相对路径创建文件
        File f3 = new File("module6_30/src/lyy.txt");
        System.out.println(f3.getPath());
        System.out.println(f3.getAbsolutePath());
        System.out.println(f3.getName());
        System.out.println(f3.exists());

    }
}
