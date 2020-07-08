package _02集合迭代器._01迭代器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class interator_demo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("张无忌");
        list1.add("赵敏");
        list1.add("周芷若");
        list1.add("小昭");


        Iterator<String> it = list1.iterator();
        System.out.println(it.next());
    }
}
