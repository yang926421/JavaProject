package com.etc.Ayy_collection.map集合;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class map_deom2 {
    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();
        //添加元素
        maps.put("iphone", 10);
        maps.put("娃娃", 30);
        maps.put("iphoneX", 100);//  Map集合后面重复的键对应的元素会覆盖前面重复的整个元素！
        maps.put("huawei", 1000);
        maps.put("生活用品", 10);
        maps.put("手表", 10);

        // 遍历 键找值的方法遍历
        Set<String> keys = maps.keySet();
        for (String key : keys) {
            System.out.println(maps.get(key));
        }

        // 直接遍历键值对
        /**
         面向对象的方式,代码更加复杂
         把键值对当成一个整体遍历,直接使用foreach 遍历
         map集合的键值对是没有数据类型的,无法直接遍历
         Set<Map.Entry<String, Integer>> entries = maps.entrySet()
         通过这行代码,将map的元素对象直接封装成set集合里元素的类型,这个类型是
         Map.Entry<String, Integer>
         */
        Set<Map.Entry<String, Integer>> entries = maps.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(entry);

        }
        // 第三种发方式 lambda
        maps.forEach((k, v) -> {
            System.out.println(k + "v");
        });
    }
}
