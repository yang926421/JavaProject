package com.lyy._04file类._02常用API;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class file_demo_api {
    public static void main(String[] args) throws IOException {
        //根据字符串里面的数据判断
        File f1 = new File("D:\\lyy\\documents\\project1\\Standard_lyy\\Standard_lyy.txt");
        System.out.println(f1.createNewFile());
        // delete只能删除空文件夹
        //mkdir只能单层创建
        //mkdirs递归创建
        // dir获取到文件夹对象   dir.list()  dir.listFiles()
        File dir = new File("D:\\lyy\\documents\\爬虫");
        // a.获取当前目录对象下的全部一级文件名称到一个字符串数组返回。
        String[] names = dir.list();
        for (String name : names) {
            System.out.println(name);
        }
        // b.获取当前目录对象下的全部一级文件对象到一个File类型的数组返回。
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        File f2 = new File("D:\\lyy\\documents\\爬虫\\picture\\");
        System.out.println(f2.exists());
        System.out.println(f2.isDirectory());
        System.out.println(f2.isFile());
        System.out.println();

        // ---------拓展------------
//        File f1 = new File("D:\\itcast\\图片资源\\beautiful.jpg");
//        long time = f1.lastModified(); // 最后修改时间！
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(time));
        File f3 = new File("D:\\lyy\\documents\\爬虫\\picture\\meinv");
        //没有文件则创建
        f3.createNewFile();
        System.out.println(f3.exists());
        System.out.println(f3.isDirectory());
        System.out.println(f3.isFile());
        System.out.println();

        // c.创建一级目录
        File f4 = new File("D:/Game/test");
        System.out.println(f4.mkdir());
        f4.delete();

        // d.创建多级目录
        File f5 = new File("D:/Game/e/a/d/ds/fas/fas/fas/fas/fas/fas");
        System.out.println(f5.mkdirs());
        f5.delete();

//        file 文件的遍历
        File f6 = new File("D:\\lyy\\documents\\爬虫\\picture\\");
        String[] NAMES = f6.list();
        File[] list2 = f6.listFiles();
        System.out.println(NAMES);
        for (String name : NAMES) {
            System.out.println(name);
        }
        System.out.println(list2);
        //获取文件最后一次修改的时间
    long time = f3.lastModified();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(time));


//        f.delete()  只能删除空文件或者空文件夹

    }
}
