package com.lyy._04转换流;

import java.io.*;

/**
 * 字节流                                     字符流
 * 字节输入流               字节输出流              字符输入流            字符输出流
 * InputStream             OutputStream          Reader               Writer   (抽象类)
 * FileInputStream         FileOutputStream      FileReader           FileWriter(实现类)
 * BufferedInputStream     BufferedOutputStream  BufferedReader       BufferedWriter(实现类，缓冲流)
 * InputStreamReader    OutputStreamWriter
 * -- 作用：可以解决字符流读取不同编码乱码的问题。
 * 可以把原始的字节流按照当前默认的代码编码转换成字符输入流。
 * 也可以把原始的字节流按照指定编码转换成字符输入流
 * 解决字符流不同编码导致的乱码问题
 */
public class Input_stream_demo1 {
    public static void main(String[] args) throws Exception {
        //提取GBK编码格式的文件
        InputStream reader = new FileInputStream("D:\\lyy\\documents\\新建文本文档.txt");
        // 把原始字节输入流通过转换流，转换成字符输入转换流
        //默认按照代码的编码格式  会乱码
//        InputStreamReader ISR = new InputStreamReader(reader);
        //
        Reader ISR1 = new InputStreamReader(reader, "GBK");
        //包装成缓冲流
        BufferedReader bfr = new BufferedReader(ISR1);
        // 4.定义一个字符串变量存储每行数据
        String line;
        // 使用一个循环读取数据(经典代码)
        while ((line = bfr.readLine()) != null) {
            System.out.println(line);
        }

    }

}
