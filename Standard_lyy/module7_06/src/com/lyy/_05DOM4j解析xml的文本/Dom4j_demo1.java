package com.lyy._05DOM4j解析xml的文本;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4j_demo1 {
    public static void main(String[] args) throws  Exception{
        //创建一个dom4j解析器对象,代表整个dom4j框架
        SAXReader saxReader = new SAXReader();
        //通过解析器对象去加载xml文件数据 成为一个document文档树对象
        Document document = saxReader.read("module7_06/src/books.xml");
        //获取根元素对象
        Element root = document.getRootElement();
        //得到第一个子元素book
        Element bookEle = root.element("book");

        //直接拿到当前book元素下的子元素文本值

        System.out.println(bookEle.elementText("name"));
        System.out.println(bookEle.elementTextTrim("name")); //去掉元素空格
        //先获取到子元素对象 再获取该文本值
        Element bookNameEle = bookEle.element("name");
        System.out.println(bookNameEle.getText());
        System.out.println(bookNameEle.getTextTrim());


    }
}
