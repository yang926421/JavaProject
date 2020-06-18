package com.etc.Ayy_collection.list集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class list_demo1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("张无忌");
        list1.add("小昭");
        list1.add("赵敏");
        list1.add("周芷若");
//        list1的遍历方式
        // list集合独有的
        for (int i =0; i<list1.size();i++){
            System.out.println(list1.get(i));
        }
        for (String s : list1) {
            System.out.println(s);

        }
//        迭代器 interator
        Iterator<String> t1 = list1.iterator();
        while (t1.hasNext()){
            System.out.println(t1.next());
        }
        // lambda
        list1.forEach(i ->{
            System.out.println(i);
        });
    }
}
