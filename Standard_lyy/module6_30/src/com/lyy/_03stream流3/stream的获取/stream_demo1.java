package com.lyy._03stream流3.stream的获取;

import java.util.*;
import java.util.stream.Stream;

public class stream_demo1 {
    public static void main(String[] args) {
        //stream的核心是先获取到stream流
        //Collection集合如何获取Stream流
        Collection<String> c = new ArrayList<>();
        Stream<String> SS = c.stream();

        // map集合获取流
        Map<String, Integer> maps = new HashMap<>();
        //获取键的stream流
        Stream s1 = maps.keySet().stream();
        //值流
        Stream s2 = maps.values().stream();
        //获取键值对的stream流   先转化为Map.Entry<String, Integer>
        Stream<Map.Entry<String, Integer>> key_values = maps.entrySet().stream();
        //数组获取流
        String[] arrs = new String[]{"JAVA", "JAVA1", "JAVA2"};
        Stream<String> ARR1 = Arrays.stream(arrs);
        Stream<String> ARR2 = Stream.of(arrs);

    }
}
