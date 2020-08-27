package com.lyy._07递归实现文件的搜索;

import java.io.File;
import java.io.IOException;

public class recursion_demo1 {
    /**
     * 思路
     * 1.获取到根目录的位置 判断是否存在该路径 是否是文件夹
     * 2.提取到当前目录下的全部一级文件对象
     * 3.判断是否存在一级文件对象,也就是是否是空目录
     * 4.循环获取到的文件对象,进行判断,如果是文件判断是不是要找的文件,如果是文件对象
     * 则进行递归
     */
    public static void main(String[] args) {
        //search_file(new File("路径"), String filename)
        search_file(new File("D:\\lyy\\documents\\爬虫"), "movie.txt");
    }

    public static void search_file(File dir, String filename) {
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().contains(filename)) {
                        System.out.println(file.getAbsolutePath());
                    }
                } else {
                    search_file(file, filename);
                }
            }

        }

    }
}
