package cn.gsxt.test;

import cn.gsxt.damain.items;
import cn.gsxt.dao.impl.itemsDaoImpl;
import org.junit.Test;

import java.util.List;

public class itemsTest {
    @Test
    public void findAll() throws Exception{
        itemsDaoImpl itemsDao = new itemsDaoImpl();
        List<items> items = itemsDao.findAll();
        for (items item : items) {
            System.out.println(item.getName());
        }
    }
}
