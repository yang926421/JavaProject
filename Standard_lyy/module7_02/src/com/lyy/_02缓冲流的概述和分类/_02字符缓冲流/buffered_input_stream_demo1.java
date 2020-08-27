package com.lyy._02缓冲流的概述和分类._02字符缓冲流;

import java.io.*;

public class buffered_input_stream_demo1 {
    public static void main(String[] args) throws Exception {
        Reader wr1 = new FileReader("module7_02/src/hht.txt");
        BufferedReader BD = new BufferedReader(wr1);
        //
//        BD.read();
//        System.out.println(BD.read());
//        System.out.println(BD.readLine());
//        System.out.println(BD.readLine());
        // 按行循环读取
//        String line;
//        while ((line=BD.readLine())!=null){
//            System.out.println(line);
//        }
//
        //定义一个数组来取数据    缓冲流效果比普通字符流快，但是只有在大文件中才能看出来效果
        char[] char1 = new char[1024];
        int len;
        while ((len = BD.read(char1)) != -1) {
            System.out.println(new String(char1));
        }
    }


}
