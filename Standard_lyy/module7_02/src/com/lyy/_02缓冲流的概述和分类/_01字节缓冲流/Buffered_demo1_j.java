package com.lyy._02缓冲流的概述和分类._01字节缓冲流;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Buffered_demo1_j {
    public static void main(String[] args) throws Exception {
        // 低级字节输入流与源文件路径地址接通
        InputStream file1 = new FileInputStream("module7_02/src/linux第一天作业.txt");
        //字节缓冲流包装
        BufferedInputStream BIS = new BufferedInputStream(file1);

        byte[] bytes1 = new byte[3];
        int len;
        while ((len = BIS.read(bytes1)) != -1) {
            System.out.println(new String(bytes1, 0, len));
        }


    }
}
