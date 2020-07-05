package com.lyy._05序列化;

/**
 序列化技术
    把对象序列化
    对象序列化
        把java对象数据直接存储到文件中  对象==>文件
    对象反序列化
        把java对象的文件数据恢复到java对象中
 字节流                                    字符流
 字节输入流               字节输出流              字符输入流          字符输出流
 InputStream             OutputStream          Reader             Writer   (抽象类)
 FileInputStream         FileOutputStream      FileReader         FileWriter(实现类)
 BufferedInputStream     BufferedOutputStream  BufferedReader     BufferedWriter(实现类，缓冲流)
                                                InputStreamReader  OutputStreamWriter
 ObjectInputStream       ObjectOutputStream


对象序列化流(对象字节输出流) objectOutputStream
    作用  把内存只中的java对象数据保存到文件中去
        构造器
        public ObjectOutputStream(OutputStream out)
        序列化方法
        public final void writeObject(Object obj)

 对象如果想参与序列化,对象必须实现序列化接口  implements Serializable,否则序列化失败




 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
public class serialize_demo1 {
    public static void main(String[] args) throws Exception{
        User us1 = new User("lyy","123456","金角大王");
        OutputStream out = new FileOutputStream("module7_02/src/obj.dat");
        //把低级的字节输出流包装成高级的对象字节输出流ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(out);
        //通过对象字节输出流将java对象写到文件中去
        oos.writeObject(us1);
        oos.flush();
        System.out.println("把对象序列化喽");
    }
}
