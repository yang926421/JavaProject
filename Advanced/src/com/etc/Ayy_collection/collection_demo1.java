package com.etc.Ayy_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class collection_demo1 {
//    Collection

    /**
     * 集合的方法
     * 添加   add()
     * 清空  clear()
     * 判断是否为空  isEmpty()
     * 判断集合中是否包含某个元素   contains(元素)
     * 删除   remove()  默认删除第一个元素
     * 集合转成数组   sets.toArray()
     * 合并两个集合   c1.addAll(c2)  c2中的集合全部放入c1中
     * <p>
     * collection 集合的遍历方式有三种
     * 1.获取迭代器
     * Iterator<String> it = list1.iterator();
     * it.next() 获取下一个元素
     * it.hasNext() 判断是否有下一个元素
     * Iterator<String> = list1.iterator()
     * <p>
     * <p>
     * 2.foreach
     * 很方便 idea快捷方式  被遍历的集合.for  回车
     * for(被遍历集合或者数组中元素的类型 变量名称:被遍历集合){
     * 执行语句
     * }
     * 缺点 没有索引 有些时候不方便使用
     * <p>
     * 3.lambda表达式
     */
    public static void main(String[] args) {
        Collection<String> list1 = new ArrayList<>();
        list1.add("周芷若");
        list1.add("张无忌");
        list1.add("赵敏");
        list1.add("小昭");
        // 获取迭代器
//        Iterator<String> it = list1.iterator();
////        System.out.println(it.next());
////        使用while循环来先判断有没有下一个
//        while(it.hasNext()){
//            System.out.println(it.next());
//
//        }
//        foreach遍历
//        for (String ele:list1
//             ) {
//            System.out.println(ele);
//
//        }
//        for (String s : list1) {
//
//        }
//        Object lambda;
//            list1.forEach( i ->{
//            System.out.println(i);
//        });
//        lambda终极版本,等效于上面语句
        list1.forEach(System.out::println);

    }
}
