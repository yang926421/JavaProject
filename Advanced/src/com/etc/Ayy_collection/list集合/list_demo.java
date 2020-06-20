package com.etc.Ayy_collection.list集合;

import java.util.ArrayList;
import java.util.List;
/**

 list系列 有序 可重复 有索引
 ArrayList 实现类集合底层基于数组存储数据的,查询快,增删慢
 开发中ArrayList集合用的最多  增删慢只是相对的,相对于链表来说 实际使用是很不错的

 LinkedList 也是list的实现类,底层是基于链表的,增删比较快,查询慢
    支持双链表.定位前后增删首位的元素是非常快的
 除了拥有List集合的全部功能还多了很多操作首尾元素的特殊功能
 LinkedList 提供了很多操作首尾元素的特殊API,可以做栈和队列的实现

 如果查询多 增删少 用ArrayLisy  (用的最多)
 如果查询少而增删多  用LinkedList


 */
public class list_demo {
    public static void main(String[] args) {
        System.out.println("ArrayList");
        //这是一行经典代码  list系列 有序 可重复 有索引
        List<String> list1 = new ArrayList<>();
        //在某个索引位置添加
//        list1.add(索引位置,索引元素)
        //删除 list1.remove(index)
        // 获取元素   list1.get(index)
        // 修改索引位置处的元素 并将原数据返回给我们
//        list1.set(0, "hhh");
//        除了有这些API,依旧可以用自己父类的collection的api
    }
}
