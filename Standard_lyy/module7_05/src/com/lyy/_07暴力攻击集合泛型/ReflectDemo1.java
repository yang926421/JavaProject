package com.lyy._07暴力攻击集合泛型;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        //泛型只能工作在编译阶段,运行阶段就消失了
        //反射工作在运行时阶段
        List<Double> scores = new ArrayList<>();
        scores.add(99.3);
        scores.add(199.3);
        scores.add(89.5);

        //通过反射暴力的注进去一个其他类型的元素
        //先得到集合对象的class文件对象
        Class c1 = scores.getClass();
        //从Arraylist的Class对象中定位add方法   第二个参数为方法需要的入参值
        Method add = c1.getDeclaredMethod("add", Object.class);
        //触发scores集合对象中的add执行(运行阶段 泛型不能约束了)
        add.invoke(scores,"波妞");
        System.out.println(scores);



    }
}
