package com.lyy._01字符流的使用;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
    字符输出流写字符出去 最后一定要关闭管道，
 可以写单个字符，也可以写字符串，还可以截取字符串的写


 */
public class FileWriterDemo1 {
    public static void main(String[] args) throws Exception {
        // 1.创建一个字符输出流管道通向目标文件路径
        //Writer fw = new FileWriter("module7_02/src/com/"); // 覆盖数据管道
        Writer wr1 = new FileWriter("module7_02/src/hht.txt", true);
        wr1.write(97);
        wr1.write('d');
        wr1.write("我是lyy,hahah");
        wr1.write("f");
        wr1.write("hhh哈哈哈");
        wr1.write("我是来自中国的兄弟",0, 3);
        wr1.close();
        Writer fw = new FileWriter("module7_02/lyy.txt",true); // 追加数据管道

        // 2.写一个字符出去：public void write(int c):写一个字符出去
        fw.write(97);   // 字符a
        fw.write('b');  // 字符b
        fw.write('磊'); // 字符磊，此时没有任何问题。
        fw.write("\r\n"); // 换行

        // 3.写一个字符串出去：public void write(String c)写一个字符串出去：
        fw.write("Java是最优美的语言！");
        fw.write("我们在黑马学习它！");
        fw.write("\r\n"); // 换行

        // 4.写一个字符数组出去：public void write(char[] buffer):写一个字符数组出去
        fw.write("我爱中国".toCharArray());
        fw.write("\r\n"); // 换行

        // 5.写字符串的一部分出去: public void write(String c ,int pos ,int len):写字符串的一部分出去
        fw.write("Java是最优美的语言！",0,9);
        fw.write("\r\n"); // 换行

        // 6.写字符数组的一部分出去：public void write(char[] buffer ,int pos ,int len):写字符数组的一部分出去
        fw.write("我爱中国".toCharArray(),0 ,2);
        fw.write("\r\n"); // 换行

        fw.close();
    }
}
