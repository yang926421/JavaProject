package com.lyy._04转换流;

import java.io.*;

public class Output_stream_demo1 {
    public static void main(String[] args) throws Exception {
        OutputStream RD1 = new FileOutputStream("D:\\新建文本文档.txt");
        Writer WR2 = new OutputStreamWriter(RD1);

//        Writer WR1 = new OutputStreamWriter(RD1, "GBK");
        //包装成指定的编码格式
//        WR1.write("我是中国人呀 哈哈哈");
        WR2.write("我是中国人呀");
        WR2.flush();

    }
}
