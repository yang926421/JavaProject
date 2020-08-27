package com.lyy._09字节流的使用;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节输出流  outputstream
 * fileoutputstream
 * <p>
 * 构造器
 * FileOutputStream(File file)  创建一个字节输出流管道通向目标文件对象
 * FileOutputStream(String file)  创建一个字节输出流管道通向目标文件路径
 * public FileOutputStream(File file , boolean append):创建一个追加数据的字节输出流管道通向目标文件对象。
 * public FileOutputStream(String file , boolean append):创建一个追加数据的字节输出流管道通向目标文件路径。
 * -- 方法：
 * public void write(int a):写一个字节出去 。
 * public void write(byte[] buffer):写一个字节数组出去。
 * public void write(byte[] buffer , int pos , int len):写一个字节数组的一部分出去。
 * 参数一，字节数组；参数二：起始字节索引位置，参数三：写多少个字节数出去。
 * 小结：
 * 字节输出流只能写字节出去。
 * 字节输出流默认是覆盖数据管道。
 * 换行用： os.write("\r\n".getBytes());
 * 关闭和刷新：刷新流可以继续使用，关闭包含刷新数据但是流就不能使用了！
 * <p>
 * 因为字节输出流默认是覆盖数据管道,如果需要是追加数据管道,需要在创建输出流的时候加参数true
 * OutputStream  os2 = new FileOutputStream(file, true)
 */
public class file_output_demo1 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\java\\project\\Standard_lyy\\module6_30\\hht");
        OutputStream os1 = new FileOutputStream(file1);
        os1.write((char) 3);
        System.out.println("hahahaha");

    }


}
