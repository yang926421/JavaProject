package com.etc.Ayy_JDK1_8_new;

import java.util.HashMap;
import java.util.Map;

public class map_demo {
    // lambda循环表达式
    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();
        //添加元素
        maps.put("iphone", 10);
        maps.put("娃娃", 30);
        maps.put("iphoneX", 100);//  Map集合后面重复的键对应的元素会覆盖前面重复的整个元素！
        maps.put("huawei", 1000);
        maps.put("生活用品", 10);
        maps.put("手表", 10);

        maps.forEach((k, v) -> {
            System.out.println(k + "v");
        });
    }

}
