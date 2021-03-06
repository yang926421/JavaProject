package com.etc.Ayy_collection.set_demo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet
 * <p>
 * 目标：TreeSet集合。
 * <p>
 * TreeSet: 不重复，无索引，按照大小默认升序排序!!
 * TreeSet集合称为排序不重复集合，可以对元素进行默认的升序排序。
 * <p>
 * TreeSet集合自自排序的方式：
 * 1.有值特性的元素直接可以升序排序。（浮点型，整型）
 * 2.字符串类型的元素会按照首字符的编号排序。
 * 3.对于自定义的引用数据类型，TreeSet默认无法排序，执行的时候直接报错，因为人家不知道排序规则。
 * <p>
 * 自定义的引用数据类型的排序实现：
 * 对于自定义的引用数据类型，TreeSet默认无法排序
 * 所以我们需要定制排序的大小规则，程序员定义大小规则的方案有2种：
 * a.直接为对象的类实现比较器规则接口Comparable，重写比较方法（拓展方式）
 * // 如果程序员认为比较者大于被比较者 返回正数！
 * // 如果程序员认为比较者小于被比较者 返回负数！
 * // 如果程序员认为比较者等于被比较者 返回0！
 * <p>
 * b.直接为集合设置比较器Comparator对象,重写比较方法
 * // 如果程序员认为比较者大于被比较者 返回正数！
 * // 如果程序员认为比较者小于被比较者 返回负数！
 * // 如果程序员认为比较者等于被比较者 返回0！
 * 注意：如果类和集合都带有比较规则，优先使用集合自带的比较规则。
 * <p>
 * 小结：
 * TreeSet集合对自定义引用数据类型排序，默认无法进行。
 * 但是有两种方式可以让程序员定义大小规则：
 * a.直接为对象的类实现比较器规则接口Comparable，重写比较方法（拓展方式）
 * b.直接为集合设置比较器Comparator对象,重写比较方法
 * 注意：如果类和集合都带有比较规则，优先使用集合自带的比较规则。
 * <p>
 * <p>
 * 目标：TreeSet集合。
 * <p>
 * TreeSet: 不重复，无索引，按照大小默认升序排序!!
 * TreeSet集合称为排序不重复集合，可以对元素进行默认的升序排序。
 * <p>
 * TreeSet集合自自排序的方式：
 * 1.有值特性的元素直接可以升序排序。（浮点型，整型）
 * 2.字符串类型的元素会按照首字符的编号排序。
 * 3.对于自定义的引用数据类型，TreeSet默认无法排序，执行的时候直接报错，因为人家不知道排序规则。
 * <p>
 * 自定义的引用数据类型的排序实现：
 * 对于自定义的引用数据类型，TreeSet默认无法排序
 * 所以我们需要定制排序的大小规则，程序员定义大小规则的方案有2种：
 * a.直接为对象的类实现比较器规则接口Comparable，重写比较方法（拓展方式）
 * // 如果程序员认为比较者大于被比较者 返回正数！
 * // 如果程序员认为比较者小于被比较者 返回负数！
 * // 如果程序员认为比较者等于被比较者 返回0！
 * <p>
 * b.直接为集合设置比较器Comparator对象,重写比较方法
 * // 如果程序员认为比较者大于被比较者 返回正数！
 * // 如果程序员认为比较者小于被比较者 返回负数！
 * // 如果程序员认为比较者等于被比较者 返回0！
 * 注意：如果类和集合都带有比较规则，优先使用集合自带的比较规则。
 * <p>
 * 小结：
 * TreeSet集合对自定义引用数据类型排序，默认无法进行。
 * 但是有两种方式可以让程序员定义大小规则：
 * a.直接为对象的类实现比较器规则接口Comparable，重写比较方法（拓展方式）
 * b.直接为集合设置比较器Comparator对象,重写比较方法
 * 注意：如果类和集合都带有比较规则，优先使用集合自带的比较规则。
 */
public class TreeSet_demo1 {
    public static void main(String[] args) {
        System.err.println("jknkkm");
        System.out.println("dddddd");

//        Set<Apple> apples = new TreeSet<>();

        Set<Apple> apples = new TreeSet<>(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                System.out.println(o1.getColor());
                System.out.println(o2.getColor());// -1 升序
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        apples.add(new Apple("111", 12.9, "黄色"));
        apples.add(new Apple("222", 18.3, "黑色"));
        System.out.println(apples);
    }


}
