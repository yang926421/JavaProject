package com.lyy._02method_quote2.方法引用的四种形式._03特定类型方法的引用;

import java.util.Arrays;
import java.util.Comparator;

//特定类型方法 比如说java提供的String , date
public class method_demo1 {
    public static void main(String[] args) {

    String[] strs = new String[]{"James", "AA", "John",
            "Patricia","Dlei" , "Robert","Boom", "Cao" ,"black" ,
            "Michael", "Linda","cao","after","sBBB"};

        //需求 按照字符串元素首字母排序  不区分大小写
//        Arrays.sort(strs);//不会区分大小写


        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //java提供的API 忽略首字母大小写排序
                return o1.compareToIgnoreCase(o2);
            }
        });
        //匿名内部类简化
        Arrays.sort(strs, (String o1, String o2) -> {
            //java提供的API 忽略首字母大小写排序
            return o1.compareToIgnoreCase(o2);
        });
        //再次简化
        Arrays.sort(strs, (o1,  o2) -> o1.compareToIgnoreCase(o2));
            //java提供的API 忽略首字母大小写排序
    //特定类型的方法引用
        //如果第一个参数列表中的形参中的第一个参数作为后面代码的主调用者,第二个参数作为被调用者形参
        // 那么就可以特定类型方法引用简写
        Arrays.sort(strs, String::compareToIgnoreCase);
        System.out.println( Arrays.toString(strs));

}
}