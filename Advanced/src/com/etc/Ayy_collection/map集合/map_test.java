package com.etc.Ayy_collection.map集合;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 目标 输出一个字符串中的每个字符出现的次数(经典面试题)
 */
public class map_test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        // 定义一个map 用来存放字符串单个的值,value 存放次数
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {

            char ch = s1.charAt(i);
            maps.put(ch, maps.containsKey(ch) ? maps.get(ch) + 1 : 1);
        }
        System.out.println(maps);


    }
}
