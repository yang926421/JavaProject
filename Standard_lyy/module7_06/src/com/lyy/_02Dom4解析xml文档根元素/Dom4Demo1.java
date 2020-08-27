package com.lyy._02Dom4解析xml文档根元素;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;

/**
 * 使用流程
 * 1.先导入dom4j框架
 * 2.创建一个dom4j解析对象 SAXReader
 * 通过解析对象把xml文件解析成document文档对象
 * 从document文档对象中获取xml信息
 */
public class Dom4Demo1 {
    public static void main(String[] args) throws DocumentException {
        //解析books.xml文件成为一个document文档树对象
        //1.创建一个dom4.j的解析器对象 代表整个dom4j框架
        SAXReader saxReader = new SAXReader();
        //2. 第一种方式  通过解析器对象去加载xml文件数据,成为一个文档树document对象
        Document document = saxReader.read(new File("module7_06/src/books.xml"));

        //3.第二种方式  (代码多点)先把xml文件读成一个字节输入流
        //直接去src路径下寻找文件
        InputStream is = Dom4Demo1.class.getResourceAsStream("/books.xml");
        Document document1 = saxReader.read(is);
        System.out.println(document1);
        //从document文档树对象中获取根元素对象
        Element root = document.getRootElement();
        System.out.println(root.getName());


    }

}
