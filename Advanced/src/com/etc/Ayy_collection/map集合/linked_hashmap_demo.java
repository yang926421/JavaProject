package com.etc.Ayy_collection.map集合;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class linked_hashmap_demo {
    //linked_hashmap 有序,不重复,无索引的
//    hashset  底层竟然是用hashmap来实现的,只是只有键,没有值'
//    linkedhashset 相当于linkedhashmap只有键,没有值
    public static void main(String[] args) {
        Map<String, Integer> maps = new LinkedHashMap<>();
        //添加元素
        maps.put("iphone", 10);
        maps.put("娃娃",30);
        maps.put("iphoneX",100);//  Map集合后面重复的键对应的元素会覆盖前面重复的整个元素！
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);
        // hashmap和linkedhashmap底层都是基于哈希表来存储数据的,所以增删改查的速度都很快
    }

}
