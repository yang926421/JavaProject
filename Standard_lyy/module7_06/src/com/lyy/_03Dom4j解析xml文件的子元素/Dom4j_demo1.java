package com.lyy._03Dom4j解析xml文件的子元素;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * 解析xml文件的子元素
 * <p>
 * getName()  取元素的名称
 * List<Element> elements():获取当前元素下的全部子元素（一级）
 * List<Element> elements(String name):获取当前元素下的指定名称的全部子元素（一级）
 * Element element(String name):获取当前元素下的指定名称的某个子元素，默认取第一个（一级）
 */
public class Dom4j_demo1 {
    //
    public static void main(String[] args) throws Exception {
        //解析books.xml文件成为一个document文件数对象
        //创建一个dom4j解析器对象  代表整个dom4j框架
        SAXReader saxReader = new SAXReader();
//  通过解析器对象去加载xml文件
        Document document = saxReader.read("module7_06/src/books.xml");
        //获取根元素对象
        Element root = document.getRootElement();
        //获取根元素下的全部子元素
        List<Element> sonElements1 = root.elements();
        for (Element element : sonElements1) {
            System.out.println(element.getName());

        }
        System.out.println("------------------------");

        //获取根元素下的全部book子元素
        //获取根元素下的全部子元素
        List<Element> sonElements2 = root.elements("book");
        for (Element element : sonElements2) {
            System.out.println(element.getName());
        }

        //获取根元素下的全部book子元素
        //获取根元素下的全部子元素
        System.out.println("------------------------");
        Element son = root.element("user");
        System.out.println(son);
        System.out.println("-----------");
        // 默认会提取第一个名称一样的子元素对象返回！
        Element son1 = root.element("book");
        System.out.println(son1.attributeValue("id"));

    }
}