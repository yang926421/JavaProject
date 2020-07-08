package _02集合迭代器._02集合._03map;

import java.util.HashMap;
import java.util.Set;

public class map_test1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("lyy",20);
        map1.put("lyy2",20);
        map1.put("lyy3",20);
        map1.put("lyy4",20);
        map1.put("lyy5",20);
        Integer v1 = map1.put("lyy2", 25);
        System.out.println(map1);
        Set<String> s1 = map1.keySet();
        map1.forEach((k, v)->{
            System.out.println(k+v);
        });
        map1.forEach((k, v)-> System.out.println(k+v));



    }
}
