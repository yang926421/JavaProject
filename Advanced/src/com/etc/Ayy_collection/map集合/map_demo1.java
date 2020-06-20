package com.etc.Ayy_collection.map集合;

import java.util.HashMap;
import java.util.Map;

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


    }
}
