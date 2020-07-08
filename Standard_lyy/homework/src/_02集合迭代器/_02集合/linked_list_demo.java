package _02集合迭代器._02集合;

import java.util.LinkedList;
import java.util.Queue;

public class linked_list_demo {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        System.out.println(list1.removeFirst());
        System.out.println(list1.removeFirst());


    }
}
