package com.lyy._02缓冲流的概述和分类._02字符缓冲流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class buffered_output_stream_demo1 {
    public static void main(String[] args) throws Exception{
        Writer wr1 = new FileWriter("module7_02/src/hht.txt");
        //将低级字符输出流 包装到高级字符输出流中
        BufferedWriter bw = new BufferedWriter(wr1);
        bw.write(22);
        bw.write("hhhhhh武松打虎");
        bw.newLine();  //缓冲字符输出流的API
        bw.write("我在河南省郑州市金水区");
        bw.flush();


    }
}
