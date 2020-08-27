package com.lyy._06打印流;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 打印流PrintStream/PrintWriter
 * <p>
 * 打印流的作用
 * 1.可以方便快速的写数据出去
 * 2.可以实现打印什么出去,就是什么
 * <p>
 * <p>
 * 打印流的构造器
 * public PrintStream(OutputStream os)
 * public PrintStream(String Filepath)
 */
public class PrintStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //打印流PrintStream
        OutputStream OS = new FileOutputStream("module7_02/src/hht2.txt");
        PrintStream ps = new PrintStream(OS);
        ps.write(97);
        ps.println(110);
        ps.write("我爱你".getBytes());
    }

}
