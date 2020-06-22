package com.etc.Ayy_collection.map集合;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 map就是字典 存key和value的值 可以有很多API使用




 */

public class map_demo1 {
    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();
        //添加元素
        maps.put("iphone", 10);
        maps.put("娃娃",30);
        maps.put("iphoneX",100);//  Map集合后面重复的键对应的元素会覆盖前面重复的整个元素！
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);

        // 常见API
        //清空
//        maps.clear();
        System.out.println(maps.containsKey("iphone"));
//        maps.keySet();// 获取到所有的键的集合  返回的是set集合
        System.out.println(maps.values());
        Set<String> keys = maps.keySet();
        for (String key : keys) {
            System.out.println(key);

        }
        //值是不做要求的,可能重复,所以值要用collection来接
        Collection<Integer> values = maps.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        maps.size();
        // 合并其它map集合
        Map<String, Integer> maps2 = new HashMap<>();
        maps2.put("小米", 1000);
        maps2.put("小米1", 1000);
        maps2.put("小米2", 1000);
        maps.putAll(maps2); //将map集合拼接,合并集合的元素




    }
}
