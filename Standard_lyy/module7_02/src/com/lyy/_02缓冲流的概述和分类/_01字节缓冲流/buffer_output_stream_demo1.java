package com.lyy._02缓冲流的概述和分类._01字节缓冲流;

import java.io.*;

public class buffer_output_stream_demo1 {
    public static void main(String[] args) throws Exception {
        OutputStream file1 = new FileOutputStream("module7_02/src/hht.txt");
        BufferedOutputStream bsm = new BufferedOutputStream(file1);
        //字节输出流
        bsm.write(65);
        bsm.write('0');
        bsm.write("我爱中国".getBytes());
        bsm.flush();

    }
}
