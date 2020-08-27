package com.lyy._06Dom4j解析案例;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Dom4j解析XML文件  Contact.xml成为一个java对象(集合对象)
 * contact.xml   ===>List<Contact>
 * <p>
 * <p>
 * 分析
 * 1.定义一个人类封装联系人数据'
 * 2.解析成List集合
 */
public class Dom4j_demo1 {
    public static void main(String[] args) throws Exception {
        // 定义一个dom4j对象代表整个框架
        SAXReader saxReader = new SAXReader();
        //读取xml文件 获取document树对象
        Document document = saxReader.read("module7_06/src/Contact.xml");
        // 获取root对象
        Element root = document.getRootElement();
        //获取根元素下的全部子元素
        List<Element> sonElements = root.elements();
        // 5.遍历子元素 封装成List集合对象
        List<Contact> contactList = new ArrayList<>();
        if (sonElements != null && sonElements.size() > 0) {
            for (Element sonElement : sonElements) {
                Contact contact = new Contact();
                contact.setId(Integer.valueOf(sonElement.attributeValue("id")));
                contact.setVip(Boolean.valueOf(sonElement.attributeValue("vip")));
                contact.setName(sonElement.elementText("name"));
                contact.setSex(sonElement.elementText("gender").charAt(0));
                contact.setEmail(sonElement.elementText("email"));
                contactList.add(contact);
            }
        }
        System.out.println(contactList);

    }
}
