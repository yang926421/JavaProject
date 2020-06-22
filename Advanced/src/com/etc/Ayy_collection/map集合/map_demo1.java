package com.etc.Ayy_collection.map集合;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 map就是字典 存key和value的值 可以有很多API使用




 */

public class map_demo1 {
    public static void main(String[] args) {
        Map<String , Integer> maps = new HashMap<>();
        // 1.添加元素: 无序，不重复，无索引。
        maps.put("娃娃",30);
        maps.put("iphoneX",100);//  Map集合后面重复的键对应的元素会覆盖前面重复的整个元素！
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);
        // maps = {huawei=1000, 手表=10, 生活用品=10, iphoneX=100, 娃娃=30}

        // a.键找值方式遍历
        // 获取当前Map集合的全部键的集合 。
        Set<String> keys = maps.keySet();
        System.out.println(keys);
        // [huawei, 手表, 生活用品, iphoneX, 娃娃]
        //          key
        // b.通过遍历键然后通过键取对应的值
        for (String key : keys) {
            // 过键取对应的值
            Integer value = maps.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
