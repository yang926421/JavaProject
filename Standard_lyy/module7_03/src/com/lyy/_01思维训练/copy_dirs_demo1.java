package com.lyy._01思维训练;

import java.io.*;

//复制文件夹(文件夹包含文件夹  递归)
public class copy_dirs_demo1 {
    /**
    源文件  D:\面试准备
    目标文件地址 D:\面试准备_copy
     */
    public static void main(String[] args) throws Exception {
        //首先要去进入拷贝文件夹的函数
        Copy_dir(new File("D:\\面试准备\\2019.3.16\\python  面试"), new File("D:\\面试准备\\2019.3.16\\python  面试_copy"));
    }
    public static void Copy_dir(File copy_dir, File dir_copy){
        // 判断是否存在源文件,且是否是文件夹
        if(copy_dir.isDirectory() && copy_dir.exists()){
            //创建复制的目标文件夹
            dir_copy.mkdirs();
            //提取源文件夹一级文件对象
            File[] files = copy_dir.listFiles();
            //判断是否存在一级文件对象
            if(files != null && files.length > 0){
                for (File file : files) {
                    //判断是否是文件夹
                    if(file.isDirectory()){
                        //文件目录下创建file文件对象
                        Copy_dir(file, new File(dir_copy, file.getName()));
                    }
                    //是文件  直接把当前文件复制过去到当前目标路径下
                    else{
                        Copy_file(file, new File(dir_copy, file.getName()));
                    }

                }
            }



        }
    }


    public static void Copy_file(File copy_file, File file_copy){
        //复制文件的逻辑
        try(
                //创建一个字节输入流指向源文件地址
                InputStream is1 = new FileInputStream(copy_file);
                //包装成缓存字节输入流
                BufferedInputStream bis = new BufferedInputStream(is1);
                //创建一个字节输出流指向目标文件
                OutputStream os1 = new FileOutputStream(file_copy);
                //包装成缓冲字节输出流
                BufferedOutputStream bos = new BufferedOutputStream(os1)
                ){
            //定义一个容器来存储字节
            byte[] buffer = new byte[1024];
            int len1;
            while((len1 = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len1);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

}
