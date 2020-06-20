package com.etc.Ayy_collection.list集合;

import java.util.LinkedList;

public class list_linklist_demo {
    public static void main(String[] args) {
       // 用linkedlist做一个队列先进先出
        LinkedList<String> queue = new LinkedList<>();
        // 入队
        queue.addLast("1号");
        queue.addLast("2号");
        queue.addLast("3号");
        queue.addLast("4号");
        //出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());


//        做一个栈
        LinkedList<String> stack  = new LinkedList<>();
        stack.push("第一颗子弹");  //内部调用了addFirst()
        stack.push("第二颗子弹");
        stack.push("第三颗子弹");
        stack.push("第四颗子弹");

        //出栈
        System.out.println(stack.pop());  //底层调用了 removeFirst

    }
}
