package com.lyy._01字符流的使用;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**

          字节流                                    字符流
  输入字节流          输出字节流          输入字符流               输出字符流
  InputStream       OutputStream        Reader               writer
  FileInputStream   FileOutputStream     FileReader        FileWriter

 -- 构造器：
 public FileReader(File file):创建一个字符输入流与源文件对象接通。
 public FileReader(String filePath):创建一个字符输入流与源文件路径接通。
 -- 方法：
 public int read(): 读取一个字符的编号返回！ 读取完毕返回-1
 public int read(char[] buffer):读取一个字符数组，
 读取多少个字符就返回多少个数量，读取完毕返回-1


  */
public class FileReaderDemo1 {
    public static void main(String[] args) throws Exception {
//        File f1 = new File("D:\\lyy\\documents\\新建文本文档.txt");
//        Reader re1 = new FileReader(f1);
        //读取的是一个字符的编号
//        re1.read();
//        System.out.println(re1.read());
        // while循环读取

//        int len_ch;
//        while ((len_ch = re1.read()) != -1){
//            System.out.println((char)len_ch);
//        }
        // 字符流可以直接读取中文
        Reader re2 = new FileReader("D:\\lyy\\documents\\project1\\Standard_lyy\\module7_02\\lyy_01");
        char[] buffer = new char[3];
        int len = re2.read(buffer);
        String str1 = new String(buffer);
        System.out.println(str1);
        // 定义一个大的 容器
        char[] buffer1 = new char[1024];
        int len2 ;
        while((len2 = re2.read(buffer1))!=-1){
            // 参数为从0开始打印出数据，如果容器不满，则有多少打印多少
            System.out.println(new String(buffer1, 0, len2));
        }



    }
}
