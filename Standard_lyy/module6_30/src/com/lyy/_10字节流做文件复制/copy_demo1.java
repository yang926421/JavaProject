package com.lyy._10字节流做文件复制;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 做文件复制
 * 思路
 * 1.创建一个字节输入流管道与源文件接通
 * 2.创建一个字节输出流管道与目标文件接通
 * 3.创建一个字节数组作为容器
 * 4.从字节输入流管道获取数据,写出到字节输出流管道
 * 5.关闭
 */
public class copy_demo1 {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try {
            /** （1）创建一个字节输入流管道与源文件接通。 */
            is = new FileInputStream("D:\\itcast\\图片资源\\meinv.jpg");
            /** （2）创建一个字节输出流与目标文件接通。*/
            os = new FileOutputStream("D:\\itcast\\meimei.jpg");
            /** （3）创建一个字节数组作为桶*/
            byte[] buffer = new byte[1024];
            /** （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。*/
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                // 读取多少就倒出多少
                os.write(buffer, 0, len);
            }
            System.out.println("复制完成！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**（5）关闭资源！ */
            try {
                if (os != null) os.close();
                if (is != null) is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

