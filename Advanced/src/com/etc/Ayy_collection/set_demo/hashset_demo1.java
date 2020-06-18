package com.etc.Ayy_collection.set_demo;

public class hashset_demo1 {
    //set集合添加的元素是不重复的,是如何去重复的
    /**
     set系列集合去重的流程
     集合和泛型都只能支持引用数据类型
     1. 对于有值特性的,set集合可以直接判断值进行去重
     2.对于引用数据类型的类对象,SET实现让两两对象先调用自己的hashcode()方法得到自己的哈希值(相当于内存地址)
     如果哈希值不同,则直接认为两个对象不重复,如果相同,会让两个对象调用equals方法,如果返回true,相同 重复了, 如果不相同则不重复

     特殊判断
        需求  如果希望set遇到内容一样的对象就重复了,那么必须重写他的hashcode方法和equals方法
     */
}
