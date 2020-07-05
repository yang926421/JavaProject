package com.lyy._06打印流;

import java.io.PrintStream;

/**
 打印流改变输出的流向,重定向

 System
    public static  void setOut(PrintStream out)
 // 让系统的输出流 流向打印流

 */
public class PrintStreamDemo2 {
    public static void main(String[] args) throws Exception{
        PrintStream PS1 = new PrintStream("module7_02/src/lyy2.txt");
        System.setOut(PS1);  //让系统的输出流流向打印流  可以作为日志文件


        System.out.println("我去0");
        System.out.println("哈哈哈哈哈哈");
    }
}
