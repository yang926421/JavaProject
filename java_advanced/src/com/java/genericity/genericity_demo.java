package com.java.genericity;

import java.util.ArrayList;
/**
 * 泛型就是一个标签 ,<数据类型>
 * 泛型可以在编译阶段约束只能操作某种数据类型 泛型和集合都支持引用数据类型,不支持基本数据类型
 * 泛型的好处
 * 泛型在编译阶段约束了操作的数据类型,从而不会出现类型转换异常
 * 体现的是java的严谨性和规范性,数据类型经常需要统一
 * <p>
 * <p>
 * <p>
 * 泛型类的概念
 * 使用了泛型定义的类就是泛型类
 * 泛型类的格式
 * 修饰符  class 类名<泛型变量>{
 * <p>
 * }
 * 泛型变量建议使用 E T K V
 * <p>
 * 泛型的核心思想
 * 是把出现泛型变量的地方全部替换成传输的真实数据
 */


//public class genericity_demo {
//    public static void main(String[] args) {
//        ArrayList<String> lists = new ArrayList<>();
//
//    }
//}
/**
 * 泛型类的概念
 *   使用了泛型定义的类就是泛型类
 泛型类的格式
 修饰符  class 类名<泛型变量>{

 }
 泛型变量建议使用 E T K V

 泛型的核心思想
 是把出现泛型变量的地方全部替换成传输的真实数据
 * */


/**
 自定义泛型方法
 定义了泛型的方法就是泛型方法
 泛型方法的定义格式
 修饰符 <泛型变量> 返回值类型 方法名称(形参列表){

 }



 */
public class genericity_demo {
    public static void main(String[] args) {
//        System.out.println("自定义泛型类");
//        // 模拟ArrayList集合
//        MyArrayList<String> list1 = new MyArrayList<>();
//        list1.add("dddddddd");
        Integer[] nums = {10, 20, 30, 40};
        String S1 = arrToString(nums);
        System.out.println(S1);

        String[] STR1 = {"贾乃亮", "王宝强", "陈羽凡"};
        String S2 = arrToString(STR1);
        System.out.println(S2);


    }

    // 泛型方法  如果不定义泛型 可以在传参 使用object来接收
    public static <T> String arrToString(T[] nums) {
        // 约束的T  T就可以接收传进来的
        StringBuilder st = new StringBuilder();
        // 拼接字符串
        st.append("[");
        // 拼接列表里面的元素
        if (nums != null && nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                //这样接收不管传进来的是什么类型都可以接收
                T ele = nums[i];
                st.append(i == nums.length - 1 ? ele : ele + ",");

            }

        }
        st.append("]");
        return st.toString();

    }
}

// 模拟ArrayList集合
class MyArrayList<E> {
    public void add(E e) {

    }

}