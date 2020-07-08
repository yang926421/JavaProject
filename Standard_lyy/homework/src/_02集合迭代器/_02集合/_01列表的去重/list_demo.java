package _02集合迭代器._02集合._01列表的去重;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class list_demo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("a");
        list1.add("f");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("d");
        HashSet<String> set = new HashSet<>();
        for (String s : list1) {
            set.add(s);
        }
        list1.clear();
        list1.addAll(set);
        System.out.println(list1);


    }


}
