package com.etc.Ayy_exception;

public class Exception_demo1 {
    //1 error 系统级错误
    // 2 编译时异常  继承自Exception的异常或其子类,编译阶段就会报错, 必须自己处理
    // 3. 运行时异常 继承自RuntimeException或其子类 ,编译阶段不会出错,但是运行阶段可能回出错,
    //这种异常会自动抛出,不用在内层抛出(throws Exception ) 但是需要在外层捕获然后处理

    /**
     1.数组越界异常
     ArrayIndexOutOfBoundsException
     2.空指针异常(直接输出没有异常,但是在调用它的API的时候就会报错,报这个异常)
     String name = null ;
     System.out.printlen(name);  //不会报异常
     System.out.printlen(name.length()); //报错
     NullPointerException
     3.类型转换异常
     ClassCastException  //强制类型转换的时候的错误,比如要把字符串转为整形
     4.迭代器遍历没有此元素
     NoSuchElementException
     5.数学操作异常
     ArithmeticException   //int c = 10/0   数学操作异常,运行的时候会报错
     6.数字转换异常
     NumberFormatException
     String age = "23a";
     Integer it = Integer.valueOf(age); //数字转换异常

     */
}
