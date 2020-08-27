package com.lyy._11Commons_IO包;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Commons-io包
 * 一个类库 别人将底层的io操作封装
 * 提高IO开发效率
 * | 包                                  | 功能描述                                     |
 * | ----------------------------------- | :------------------------------------------- |
 * | org.apache.commons.io               | 有关Streams、Readers、Writers、Files的工具类 |
 * | org.apache.commons.io.input         | 输入流相关的实现类，包含Reader和InputStream  |
 * | org.apache.commons.io.output        | 输出流相关的实现类，包含Writer和OutputStream |
 * | org.apache.commons.io.serialization | 序列化相关的类
 * <p>
 * <p>
 * FileUtils 和 IOUtils可以方便的复制文件和文件夹
 */
public class CommonsIODemo {
    public static void main(String[] args) throws Exception {
        // 1. 完成文件复制
        IOUtils.copy(new FileInputStream("module7_06/src/books.xml"), new FileOutputStream("module7_06/src/books1.xml"));
//       完成复制文件到指定文件夹下
//        FileUtils.copyFileToDirectory();
//        //完成文件夹复制到某个文件夹下
//        FileUtils.copyDirectoryToDirectory();

        //  Java从1.7开始提供了一些nio, 自己也有一行代码完成复制的技术。
        Files.copy(Paths.get("Day13Demo/src/books.xml")
                , new FileOutputStream("Day13Demo/new11.txt"));
    }

}
