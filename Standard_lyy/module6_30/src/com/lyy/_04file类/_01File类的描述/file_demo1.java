package com.lyy._04file类._01File类的描述;

import java.io.File;
/**
 File类的创建文件对象的API:
 包：java.io.File
 （1）构造器：
 -- public File(String pathname):根据路径获取文件对象
 -- public File(String parent , String child):根据父路径和文件名称获取文件对象！
 -- public File(File parent , String child)

 File类创建文件对象的格式:
 a.File f = new File("绝对路径/相对路径");
 绝对路径：从磁盘的的盘符一路走到目的位置的路径。
 -- 绝对路径依赖具体的环境，一旦脱离环境，代码可能出错！！
 -- 一般是定位某个操作系统中的某个文件对象。
 相对路径：不带盘符的。（重点）
 -- 默认是直接相对到工程目录下寻找文件的。
 -- 相对路径只能用于寻找工程下的文件。
 -- 能用相对路径就应该尽量使用，可以跨平台！

 b.File f = new File("文件对象/文件夹对象");
 广义来说：文件是包含文件和文件夹的。
 小结：
 创建文件对象可以用绝对路径也可以用相对路径。
 相对路径只能用于寻找工程下的文件。
 文件对象可以表示文件也可以表示文件夹！
 */

public class file_demo1 {

    public static void main(String[] args) {
        File f1 = new File("D:\\lyy\\documents\\project1\\Standard_lyy\\Standard_lyy.iml");
        System.out.println(f1.getName());
    }}
