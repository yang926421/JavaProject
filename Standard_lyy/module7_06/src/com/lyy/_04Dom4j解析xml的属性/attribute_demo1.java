package com.lyy._04Dom4j解析xml的属性;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class attribute_demo1 {
    public static void main(String[] args) throws Exception {
        //创建一个dom4j解析器对象,代表整个dom4j框架
        SAXReader saxReader = new SAXReader();
        //通过解析器对象去加载xml文件,成为一个document文档树对象
        Document document = saxReader.read("module7_06/src/books.xml");
        //获取到根节点root对象
        Element root = document.getRootElement();
        //获取book子元素
        Element bookEle = root.element("book");
        //5获取book元素的全部属性对象
        List<Attribute> attributes = bookEle.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName() + "====>" + attribute.getValue());
        }
        //6获取Book元素的某个属性值
        Attribute descAttr = bookEle.attribute("desc");
        System.out.println(descAttr.getName() + "------" + descAttr.getValue());

        //可以直接获取元素的属性值
        System.out.println(bookEle.attributeValue("id"));


    }
}
