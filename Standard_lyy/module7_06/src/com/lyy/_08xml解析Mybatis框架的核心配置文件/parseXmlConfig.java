package com.lyy._08xml解析Mybatis框架的核心配置文件;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;
import java.util.jar.Attributes;

/**

 */
public class parseXmlConfig {
    @Test
    public void parse_xml() throws Exception{
        SAXReader saxReader = new SAXReader();
        // 指向文件对象创建document树
        Document document = saxReader.read(parseXmlConfig.class.getResourceAsStream("/sqlMapConfig.xml"));
        //
        Element root = document.getRootElement();
        //获取子元素的Element
        Element environments = root.element("environments");
        // 获取到属性id的元素
        List<Node> nodes = document.selectNodes("./@id");
        List<Node> nodes1 = document.selectNodes("./eniverment/dataSource");
        Element dataSource = root.element("dataSource");
        List<Element> pro = dataSource.elements();
        for (Element element : pro) {
            System.out.println(element.getName() + "====>" +element.attributeValue("value"));
        }
    }
}
