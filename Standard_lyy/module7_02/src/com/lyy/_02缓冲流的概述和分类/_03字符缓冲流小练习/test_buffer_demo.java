package com.lyy._02缓冲流的概述和分类._03字符缓冲流小练习;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test_buffer_demo {
    /**
     把测试案例按照文件顺序排序存放到一个新文件目录中
        1.创建一个缓冲字符输入流包装字符输入流接通源文件
        2.定义一个list集合用于存放读取的数据
        3.循环读取，存放
        4.对list集合中的元素按照首字母排序
        5.创建一个缓冲字符输出流包装字符输出流接通目标文件地址
        6.遍历list集合，输出到目标文件中

     */


    public static void main(String[] args) throws Exception{
        Reader R1 = new FileReader("module7_02/src/csb");
        BufferedReader buf = new BufferedReader(R1);
        BufferedWriter buf_w = new BufferedWriter(new FileWriter("module7_02/src/copy_csb"));
        List<String> list_csb = new ArrayList<>();
        String line;
        while (( line = buf.readLine())!=null){
            list_csb.add(line);
        }
        System.out.println(list_csb);
        List<Character> sizes = new ArrayList<>();
        Collections.addAll(sizes,'零','一','二','三','四','五','六','七','八','九','十');
        //对list中的数据进行排序
//        Collections.sort(list_csb, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return sizes.indexOf(o1.charAt(0)) - sizes.indexOf(o2.charAt(0));
//            }
//        });
        // lambda表达式对代码进行缩减
        Collections.sort(list_csb, ((o1, o2) -> sizes.indexOf(o1.charAt(0))-sizes.indexOf(o2.charAt(0))));
        System.out.println(list_csb);
        //遍历list集合
        for (String s : list_csb) {
            buf_w.write(s);
            buf_w.newLine();


        }
        buf_w.flush();


    }
}
