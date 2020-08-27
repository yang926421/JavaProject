package com.lyy._09字节流的使用;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * a.FileInputStream文件字节输入流。
 * -- 作用：以内存为基准，把磁盘文件中的数据按照字节的形式读入到内存中的流。
 * 简单来说，就是按照字节读取文件数据到内存。
 * -- 构造器：
 * 1.public FileInputStream(File path):创建一个字节输入流管道与源文件对象接通。
 * 2.public FileInputStream(String pathName):创建一个字节输入流管道与文件路径对接。
 * -- 方法：
 * 1.public int read():每次读取一个字节返回！读取完毕会返回-1。
 * 2.public int read(byte[] buffer):从字节输入流中读取字节到字节数组中去，
 * 返回读取的字节数量，没有字节可读返回-1。
 * 小结：
 * public int read(byte[] buffer):从字节输入流中读取字节到字节数组中去，
 * 返回读取的字节数量，没有字节可读返回-1。
 * 使用字节数组读取内容，效率可以。
 * 但是使用字节数组读取文本内容输出，也无法避免中文读取输出乱码的问题。
 * <p>
 * 读取文本文件不建议使用字节流,使用字符流
 */
public class file_input_demo2 {
    public static void main(String[] args) throws Exception {
        // 分解写法
//        File file = new File("D:\\lyy\\documents\\project1\\Standard_lyy\\module6_30\\lyy.txt");
//        InputStream is = new FileInputStream(file);
//        //简便写法
//        InputStream is = new FileInputStream("D:\\lyy\\documents\\project1\\Standard_lyy\\module6_30\\lyy.txt");
//        // 定义一个桶 就是一个数组 一次可以多取数据
//        byte[] buffer = new byte[3];
//        // 从is管道中读取字节装入到字节数组中,返回数量
//        int len = is.read(buffer);
//        System.out.println("读取了字节数"+len);
//        String rs = new String(buffer);
//        System.out.println(rs);
//        int len1;
//        while((len1 = is.read(buffer))!=-1){
//            String rs2 = new String(buffer, 0, len1);
//            System.out.println(rs2);
//
//        }

        File file1 = new File("D:\\java\\project\\Standard_lyy\\module6_30\\lyy.txt");
        InputStream is1 = new FileInputStream(file1);

        //定义一个与文件大小一致的容器来进行取全部字节数据
        byte[] buffer1 = new byte[(int) file1.length()];
        // 把数据读取到这个容器中
        int len2 = is1.read(buffer1);
        System.out.println("读取了" + len2);
        String RES2 = new String(buffer1);
        System.out.println(RES2);


    }
}
