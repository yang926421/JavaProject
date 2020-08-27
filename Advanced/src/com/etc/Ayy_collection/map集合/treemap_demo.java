package com.etc.Ayy_collection.map集合;

import com.sun.jdi.ObjectReference;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class treemap_demo {
    public static void main(String[] args) {

        Map<orange, String> oranges = new TreeMap<>(new Comparator<orange>() {
            @Override
            public int compare(orange o1, orange o2) {
                System.out.println(o1.getColor());
                //正数从小到大排序  负数大到小排序
//                return o1.getPrice() - o2.getPrice();
//                因为方法是 int 如果要比较的是double类型  就要直接调用人家写好的接口 Double.compare
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        oranges.put(new orange(99, "黄色", 78.9), "rib");
        oranges.put(new orange(78, "色色", 98.8), "澳大利亚");
        System.out.println(oranges);

    }

}
