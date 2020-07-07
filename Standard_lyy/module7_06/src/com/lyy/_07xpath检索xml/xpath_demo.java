package com.lyy._07xpath检索xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 xpath用来解析整个xml数据  xpath检索某些信息

 xpath使用必须要导入Dom4j框架  然后导入xpath特有的框架包  jaxen-1.1.2.jar

 xpath的常用API
    List<Node> selectNodes(String var1): 检索出一批节点集合
    Node selectSingleNode(String var1) 检索出一个节点返回

 xpath提供的四种检索数据的写法
    1.绝对路径
    2.相对路径
    3 全文搜索
    4 属性查找

 */
public class xpath_demo {
    @Test
    public void path01() throws  Exception{
        //
        SAXReader saxReader = new SAXReader();
        InputStream is = xpath_demo.class.getResourceAsStream("/Contact.xml");
//        Document document = saxReader.read("module7_06/src/Contact.xml");
        Document document = saxReader.read(is);
        Element root = document.getRootElement();
        //使用绝对路径定位到全部的name
        List<Node> nameNodes = document.selectNodes("contactList/contact/name");
        for (Node nameNode : nameNodes) {
            System.out.println(nameNode.getText());
        }
        //使用相对路径
//        .代表当前根元素路径对象  contactList
        List<Node> nameNodes1 = document.selectNodes("./contact/name");

        //全文搜索
        //元素  在全文下查找这个元素
        List<Node> nameNodes2 = document.selectNodes("//name");
        //检索全文的contact下面的name
        List<Node> nameNodes3 = document.selectNodes("//contact/name");
        List<Node> nameNodes4 = document.selectNodes("//contact//name");
        for (Node nameNode : nameNodes2) {
            System.out.println(nameNode.getText());
        }
        //检索全部属性对象
        List<Node> attributes = document.selectNodes("//@id");
        for (Node attribute : attributes) {
            Attribute attr = (Attribute) attribute;
            System.out.println(attr.getName() + "--->"+attr.getValue());
        }

        // 4.//元素[@属性名称]  在全文检索包含该属性的元素对象
        List<Node> nodeEles = document.selectNodes("//contact[@id]");
        for (Node nodeEle : nodeEles) {
            System.out.println(nodeEle.getName());
        }

        System.out.println("---------------");
        // 5. //元素[@属性名称=值]  在全文检索包含该属性的元素且属性值为该值的元素对象。
        Node nodeEle = document.selectSingleNode("//contact[@id=2]");
        Element ele = (Element) nodeEle;
        System.out.println(ele.elementTextTrim("name"));

    }
}
