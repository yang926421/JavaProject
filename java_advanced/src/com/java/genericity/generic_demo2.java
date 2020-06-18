package com.java.genericity;

//自定义泛型接口
//    使用了泛型定义的接口就是泛型接口

// 泛型接口的格式
    // 修饰符 interface 接口名称<泛型变量>{
// }
//  泛型接口的核心思想  在实现接口的时候传入真是的数据类型  重写的方法就是对该数据进行操作
public class generic_demo2 {
    public static void main(String[] args) {
        Data data = new student_data();
        data.add(new student());

    }
}
