package com.lyy._05序列化;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

//把文件中的序列化对象反序列化成java对象
public class Serializer_demo2 {
    public static void main(String[] args) throws Exception {
        InputStream is1 = new FileInputStream("module7_02/src/obj.dat");
//    用一个高级的对象反序列化流包装低级的字节输入流
        ObjectInputStream ois = new ObjectInputStream(is1);
        User us1 = (User) ois.readObject();
        System.out.println(us1);
        System.out.println("将文件中的java对象序列化数据转换成java对象了");

    }


}
