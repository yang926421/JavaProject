package com.etc.Ayy_collection.map集合;

import java.util.*;

public class map2 {


    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("苹果", 100);
        maps.put("香蕉", 101);
        maps.put("猕猴桃", 103);
        List<String> list1 = new ArrayList<>(maps.keySet());
        System.out.println(list1);
        for (String s : list1) {
            System.out.println(maps.get(s));
        }
        Collection<Integer> values = maps.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        //键值对的方式遍历
        Set<Map.Entry<String,Integer>> entries = maps.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=>" + value);
        }
//        lambda表达式
        maps.forEach((k, v) ->{
            System.out.println(k+v);
        });
    }
}
