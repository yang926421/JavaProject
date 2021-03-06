# 基础

第一个Java程序

```
public class Hello{
    public static void main(String[] args){
        System.out.printlen("Hello world");
    }
}
```



java 程序严格区分大小写   标点符号必须是英文符号

Java编译文件的时候

1 javac 文件名.java

2 运行  java 类名

java的注释

//  单行注释

/*  */    多行注释

文档注释 是对整个文档进行的注释   /**  */

类是java程序可以被执行的最小单元



变量的意义

​	把程序运行过程中产生的值,方便后面使用

变量和int

## java的数据类型

1 int 整数

```
加减乘除取余
+ - * / %
java中如果左右两边都是int 结果就是int  整数10/20 = 0 余10
```

double 小数

```
 + - * /  % 
 操作和int基本一样 不同的是 double计算的结果一般都是double
 
```

boolean 布尔值

true  false

String 字符串

```
字符串的拼接  运算过程和数学上是一样的,从左到右,先算括号  字符串+int  int也会是字符串  例如lyy+10   lyy10
```

## 用户输入

Scanner

```
先创建个扫描器 需要导包  import java.util.Scanner
Scanner sc = new Scanner(System.in)
类型 变量名 = sc.next...()  获取到要输入的内容
```

## if判断语句

```
if(判断1){
    执行语句1
}
else if(判断2){
    执行语句2
}
else{
都不满足 执行语句3    
}
```

## while循环

```
import java.util.Random;
import java.util.Scanner;
public class homework {
    public static void main(String[] args){
        System.out.println("写一下作业嘛,太low了");
        // 写一个random实例大概
        Random rd = new Random();
        int n = rd.nextInt(100); // n是一个随机数,范围是[0,99]
        System.out.println(n);
        // 用户输入
        System.out.println("来猜一下");
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            int a = sc.nextInt();
            if (a > n) {
                System.out.println("猜大了,继续猜");
            } else if (a < n) {
                System.out.println("猜小了,继续猜");
            } else {
                System.out.println("猜对了");
                flag = false;
            }
        }
    }
}

```

编码

utf - 8 可变长度的unicode

英文 8bit  1byte

欧洲文字  16bit 2byte

中文 14bit 3byte



## 基础数据类型 整数

int 整数  32bit  4byte   -21亿~21亿

byte  java中最小的数据单元  8bit  -128~127 之间

short 短整数  16bit  -32768~32767  2byte

long长整数     64bit 8byte



## 数据类型 小数

双精度小数,精度高,准确性高

double   64bit  8byte(比较大 在内存中是比较浪费的)

单精度小数

float  32bit  4byte



## 基本数据类型_字符

字符 单一的文字符号

char  16bit  unicode标准 定长 

char类型可以存放数字,存放的数字实际上是字符

## 基础数据类型 boolean

boolead 取值范围 true, false

在内存中有0和1 就够了  但是在内存中占用的是8个字节  1byte



基本数据类型小结

整数

​	1 byte字节 8位

​	short 短整数  16bit 2 byte

​	int 整数 32bit 4byte

​	long 长整数  64bit  8byte

小数

​	float 单精度小数 32bit 4 byte

​	double 双精度小数   64bit 8byte

字符

​	char 单一文字符号  16bit 2byte

​	必须用单引号括起来

布尔

​	Boolean  计算机中 8bit 1byte

​	true false

## 基本数据类型转换

顺序 数据量的大小

byte -> short, char -> int -> long -> float -> double 

小数据类型转换成大数据类型   安全,直接转化

大数据类型  -> 小数据类型   不一定安全,可能会出现问题

```
public class TestConvert {
    public static void main(String[] args){
        System.out.println();
        int a = 10;
        long b = a;
        System.out.println(b);
        long c = 10;
        int d = (int)c;
        System.out.println(d);  //小转大  强转尽量限制 可能会有问题


    }
}

```

## 基本数据类型之间的运算

1.相同数据类型之间

​	相同数据类型,得到的一定是这个数据类型

​	int + int = int

​	int / int = int   10/3=3

2.不同数据类型

​	int + long = long

​	首先,把小的数据类型自动转换成大的数据类型,然后再进行计算,得到的结果一定是大的数据类型

3.特殊的short byte short

​	不管什么情况,这种都要特殊对待

​	在计算的时候首先会转换成int再进行运算,这样是安全的

```
面试题
	1.问会打印什么结果
	short s1 = 1;

	short s2 = s1 + 1;

	system.out.println(s2);
	会报错,不打印
```

## 基本运算符,算数运算

```
 + - * /
 public class TestSuan {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(a/b);
        System.out.println(a%b);
    }
} 
```

## 运算符_赋值扩展运算

```
=  把等号右边的计算结果赋值给等号左边的变量
+=  累加
-=
*=
/=
%=
```

## 运算符 比较运算

```
>
<
>=
<=
==
!=
比较运算的结果 
```

逻辑运算

```
&& 并且  左右两端同时为真 结果才为真
|| or  有一个成立则为True
! 非 
```

## while 循环

```
如果没有break 会产生case穿透现象
一个case被匹配成功,后面的case就不匹配了,但是会执行里面的代码
```

## for循环

for(语句1;语句2; 语句3){

循环体

}

for(int i= 0; i<10; i++){

执行语句

}

## do...while循环

​	while(条件){

​	循环体

}

do...while

do{

​	执行语句

}

while{条件判断}

## break和continue

```
break跳出整个循环
continue跳出单个循环

```

## 数组

具有相同数据类型的集合

java中的数组

类型[] 数组名 = new 类型[大小];

类型[] 数组名 = {数据,数据,数据....};

类型[] 数组名 = new 类型[]{数据,数据,数据}

```
public class shu_list {
    public static void main(String[] args) {
        System.out.println();
        // 三种创建数组的方式
        int[] arr1 = new int[5];
        int[] arr2 = {22, 33, 44};
        int[] arr3 = new int[]{22, 33, 55};
        // 数组必须配合数组的下标进行使用,下标从0开始
        int[] arr4 = {23, 45, 67, 87, 44};
        System.out.println(arr4[4]);
        for (int i=0; i< arr4.length; i++){
            System.out.println(arr4[i]);
        }
    }
}     

```

方法的返回值

```
返回值 :执行方法之后得到的结果
public static 返回值类型 方法名(){
    方法体;
    return 值;
}
注意:
1.返回值类型和返回值必须匹配
2.如果写了返回值类型,必须要有返回值
3.如果写了返回值,必须要有类型
4.没有返回值.返回值类型写void
5.return之后的语句不会再调用
```

## 方法的参数

参数:在方法执行的时候,给方法传递的信息

public static 返回值类型 方法名(形参){

​	方法体

}

方法(实参)

## 方法的重载

方法的名字相同,参数的个数不同或者类型不同,会自动匹配重载

和返回值没有关系

在执行过程中,程序会自动根据参数去找对应的方法,执行

方法的重载可以让我们省去起名字的烦恼



### ==

java中的 == 相当于Python中的is 指的是内存地址相等

java中的  equals() 比较的是值是否相等  类似于Python中的==  

# 面向对象

## 类的五大成分之一

成员变量  方法 构造器   代码块 内部类 

```
写代码
	类要使用class 来定义
	属性:成员变量直接写在类中的变量(写在方法中的变量  局部变量)
	方法:不写staic的成员方法
java分为两种数据类型
	1.基本数据类型
	2.引用数据类型 String和我们创建的所有类
//去掉static就是成员方法
public void test(){
    
}
创建对象
类 引用 = new 类()
```

## this 关键字

```
调用方法的时候,java会自动把对象传递给方法,在方法中用this来接收
this  当前类的对象
this 可以在方法内部获取对象中的属性信息
this还可以区分局部变量和成员变量
```

## 构造方法

语法

java 会自动的赠送给每一个类一个无参数的构造方法

如果自己定义了构造方法,,可以传递参数.java就不再赠送这个构造方法了,系统会调用你写的构造方法

在创建对象的时候,自动调用的方法

​	public 类名(){

​		}

## 构造方法的重载

构造方法也是方法,也可以进行重载

作用:可以有更多的方法去创建对象

使用this可以访问类中其他的构造方法  this()

![1591869457075](C:\Users\ADMINI~1\AppData\Local\Temp\1591869457075.png)

## static 静态

java面向对象中的类

static  int i = 47; 设置静态变量  对象.i改变的话 全局都会改变     两个对象调用i指的是同一块内存区域
推荐使用  类名.i  类名.变量

特点

​	1.数据共享

​	2.属于类的,并不属于对象

​	3.优先于对象产生的



通用构造器,静态构造器

创建对象的过程():

​	1.静态构造器

​	2.通用构造器

​	3.构造方法  ->创建对象  按照顺序走

由于创建对象的过程是在静态文件内容加载完成之后,在静态方法和静态块里是不能使用this来调用参数的    静态的内容推荐使用类名去访问.

​	

## 包

一般使用域名的翻转

创建包   com.lyy.www  可以理解为com文件夹下的lyy文件夹下的www

在代码中 需要写package 包名

在自己文件夹(相同包下)下 使用其他类不需要导包,在其他文件夹下就找不到那个类 就需要导包

在java.lang下的所有内容都不需要导包  比如 sout(system out printlen())   String



## 访问权限(权限修饰符)

1.public  公共的  所有人都可以访问

2.default  默认的缺省 

3.protected  包访问权限,在自己包里可以随便使用

3.private  私有的

用的最多的是private和public

![1592275942134](C:\Users\ADMINI~1\AppData\Local\Temp\1592275942134.png)

## setter和getter

成员变量一般使用setter和getter

setter主要是给成员变量赋值,做一定的保护

getter 从成员变量中获取数据



在 idea中快捷生成

右键  generate -> getter and setter  全选  会自动生成





## 继承

子类可以继承父类中除了私有内容的所有内容. public class B extends A{}



## super关键字

super 表示父类中的内容

This表示自己类中的内容  用super和this来区分父类和子类中重名的变量



创建对象的时候:先创建父类的对象然后创建子类的对象



小总结

 super可以获取到父类中的内容

可以调用父类中的构造方法,必须写在子类构造方法的第一行 如果父类的构造方法是无参数的,可以不写,如果父类没有无参数的构造,必须要写super

因为可以有好几个构造方法.



## 方法的重写

重写  子类对父类方法的重写

子类中的方法必须和父类中的方法完全一致,重写又被称为方法的覆盖.

super可以调用父类中被子类重写的方法.



## 多态

多态 : 同一个对象拥有多种形态

​	同一个类型的对象,执行不同法人行为,在不同的状态下,会表现出不同的行为特征.

多态的识别技巧

​	对于方法的调用,方法看左边,运行看右边

​	对于变量的调用,方法看左边,运行看左边

作用: 把不同的数据类型进行统一,让程序具有超强的可扩展性



小知识点:

​	1.把子类的对象赋值给父类的变量  -> 向上转型 

​	animal ani1 = new cat()

​	缺点: 屏蔽掉子类特有的方法  比如说猫 赋值给动物 然后动物便不能调用猫特有的方法  抓老鼠.可以再使用向下转型  cat cc = (cat)ani1

​	2.把父类的变量转化回子类的变量 ->向下转型

​	向下转型有可能有风险,java要求必须要写强制类型转换

​	(转换之后的数据类型) 变量

### 	小结

​		有继承/实现关系的两个类型就可以强制类型转换,编译阶段不会报错,但是运行阶段可能会出现异常ClassCastException

​		java 建议在进行强制类型转换之前先判断变量的真实类型,再强制类型转换

​		语法   变量  instanceof 类型  判断前面的变量是否是后面的或者类型或者其子类类型才返回True

## final关键字

1.被final修饰的变量,不可以被改变.又被称为常量

2 被final修饰的方法不能被重写  和static同位置  public finalvoid fun(){}

3.被final修饰的类不可以被继承

final 总结  就是不可变

## 抽象

![1591956071709](C:\Users\ADMINI~1\AppData\Local\Temp\1591956071709.png)

## 接口

接口实际上是一种特殊的抽象类,接口中全部都是抽象方法和常量,没有其他成分.

接口中所有的方法都是抽象方法,

接口使用interface来声明



能继承接口的只能是接口，接口和类的关系只能是实现关系

### 接口有啥用

​	接口体现的是规范思想,实现接口的类必须重写完接口中全部的抽象方法.  规范== 约束

类只能单继承，接口支持多实现.接口称为被实现,实现接口的类称为实现类

 接口同样具有多态性

接口可以把很多不相关的东西进行整合

### 特点 

接口中所有的方法都是抽象方法 都是公开的‘所以可以省略public abstruct不写

接口中所有的变量都是全局静态变量

子类  继承  父类

实现类  实现  接口

## 成员变量初识值

java中所有的变量必须先声明后赋值才能使用

java中的成员变量，再创建对象的时候都会执行一次初始化操作，都会给一个默认值

基本数据类型默认值都是0  包括boolean  -> false  在计算机语言中false也是0

引用数据类型 比如自己写的类 和 string  都是null

null表示空,什么都没有,占位

## object类

一切皆为对象  什么是一种什么   就要用继承

所有的东西都是对象

在java中的所有的类都是继承object

object是一个类  所有类的跟

我们写的类即使不写继承关系

## equals和==

equals相当于python的==   值相等

==相当于python的is   内存地址

equals如果子类不重写 默认调用的是父类object的equals方法,我们

在子类中可以重写equals判断的方法,对要进行判断的两个对象的属性进行自己逻辑的判断.这样就也可以判断不同对象值相等的时候,返回true

![1592357149446](C:\Users\ADMINI~1\AppData\Local\Temp\1592357149446.png)

字符串中重写了equals方法

![image-20200613162100369](C:/Users/Administrator/AppData/Roaming/Typora/typora-user-images/image-20200613162100369.png)

string str3 = new String("杠精")   其实是创建了一个杠精对象创建了一个string对象 string对象指向杠精  

字符串的判断一定是用equals

## tostring方法

toString()对一个对象的字符串的表示形式   父类中默认的toString返回的是

包名+类名+@+内存地址

java推荐子类重写toString方法  idea可以快捷生成 generate

## objects类

objects类的使用

objects类与object还是继承关系

objects类是从JDK1.7之后才有的

objects的方法

​	1.public static boolean equals(object a, object b)

​			-比较两个对象的

​			-底层进行非空判断,从而可以避免空指针异常,更安全

​	2.这个方法比较鸡肋,不怎么会使用

​		System.out.println(Objects.isNull());

​		判断变量是否为NULL,为null则返回true



```
package com.java.objects_test;
import java.util.Objects;
/**
 *
 *
 * 源码中的书写方法
 public static boolean equals(Object a, Object b) {
 return (a == b) || (a != null && a.equals(b));
 }
 * */

public class test_objects {

    public static void main(String[] args) {
        student s1 = new student();
        student s2 = new student();
        System.out.println(s1.equals(s2));
        System.out.println(Objects.equals(s1, s2));
    }
}

```



## instanceof关键字

判断某某某对象是不是xx类型的

![1592357187946](C:\Users\ADMINI~1\AppData\Local\Temp\1592357187946.png)

异常的家族体系

## 异常的分类

1.Runtimeexception   运行时异常,一般不手动处理 出问题了才处理,这种异常不会直接在写代码的时候显示错误

2.其它exception  必须要经过手动处理

3.Error  一般是系统级错误  

## 异常的处理

try{

}

catch (){

}

finally{

}

## 异常的处理_throws和throw

## ![1592796888145](C:\Users\ADMINI~1\AppData\Local\Temp\1592796888145.png)

面试题

常见的几种运行时异常

```
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

```



## Date

Date d1 = new Date();   创建时间对象

```
package com.java.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 构造器
 public Date(): 创建当前系统的此刻日期时间
 public Date(long time);  将传进来的时间毫秒值转换成为日期时间

 * */

public class DateDemo1 {

    public static void main(String[] args) {
        Date d1 = new Date();
//        //打印出人类可读的时间格式
//        System.out.println(d1);
//
//        long l1 = d1.getTime();
//        //时间戳,时间毫秒值
//        System.out.println(l1);
        //计算程序流程时间
//        long st = new Date().getTime();
//        for (int i=1; i< 100000; i++){
//            System.out.println("输出+"+i);
//        }
//        long e1 = new Date().getTime();
//        System.out.println((e1 - st)/1000.0);
        System.out.println(d1);
        //拿到此刻时间往后走121秒
        long time = d1.getTime() + 121*1000;
        Date d2 = new Date(time);
        System.out.println(d2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss a");
        //开始调用方法格式化时间得到字符串
        String RS = sdf.format(d1);
        System.out.println(RS);
    }
}

```



简单日期格式化类SimpleDateFormat 可以把日期对象格式化成我们喜欢的时间格式

DateFormat作用

## Calendar 日期类的使用

```
package com.java.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 Calendar 代表了系统此刻日期对应的日历对象
 Calendar 是一个抽象类,不能直接创建对象
 Calendar 创建日历对象的语法
    Calendar  right_now = Calendar.getInstance();
 Calendar的方法
    public static Calendar getInstance(); 返回一个日期类对象
    public int get (int field); 取日期中某个字段的信息
    public void set(int field, int value); 修改某个字段的信息为value值
    public void add(int field, amount); 为某个字段增加减少指定的值
    public final Date getTime();  拿到此刻时间的对象
    public long getTimeInMillis();  拿到此刻时间对应的毫秒值
 */


public class calendar_demo1 {
    //Calendar
    public static void main(String[] args) {
        // 通过调用日历类的静态方法getInstance得到一个当前此刻日期对象对应的日历对象
        Calendar right_now = Calendar.getInstance();
        System.out.println(right_now);
        //1 获取年
        int year = right_now.get(Calendar.YEAR);
        //2 获取月
        int mm = right_now.get(Calendar.MONTH) + 1;
        //3 获取一年中的哪一天
        int dd = right_now.get(Calendar.DAY_OF_YEAR);
        //4 修改日历的信息
        right_now.set(Calendar.YEAR, 2099);
        System.out.println(right_now.get(Calendar.YEAR));
        //5 日历可以得到此刻日期对象  是先拿到日历对象 再拿日期对象 比较鸡肋
        Date d = right_now.getTime();
        // 得到此刻的日期对象
        System.out.println(d);
        // 6 时间毫秒值   通过日历来拿 提供这个API接口  我们可以不用
        long time = right_now.getTimeInMillis();
        System.out.println(time);
        // 日历向后走多少天的日期对象
        right_now.add(Calendar.DAY_OF_YEAR, 701);
        System.out.println(right_now);
        // 向日历后走多少时分秒
        right_now.add(Calendar.HOUR, 45);
        right_now.add(Calendar.MINUTE, 45);
        right_now.add(Calendar.SECOND, 45);
        //拿到向前的日历对象  只需要把时间值改为负即可

    }

}

```

## System类

```
package com.java.system;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 System 类 代表当前系统
 System.exit(0)    终止jvm虚拟机  非0是异常终止
 System.currentTimeMillis() 获取当前系统时刻的毫秒值
 public static native void arraycopy(Object src,  int  srcPos,
 Object dest, int destPos,int length);
 1.原数组  2 从原数组哪个位置可以开始赋值  3目标数组  4 赋值到目标数组哪个位置 5 赋值几个

 */

public class system_demo {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();//获取当前系统时间毫秒值
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(time));
        int[] arr1 = new int[]{10, 20,30,40,50,60};
        int[] arr2 = new int[6];  // [0,0,0,0,0,0]
        System.arraycopy(arr1, 2, arr2, 0, 3);
        System.out.println(Arrays.toString(arr2));
    }
}

```

BigDecimal 大数据类

解决浮点型数据运算的时候导致的数据精度丢失问题

```
package com.java.big_decimail;

import java.math.BigDecimal;

public class big_decimal_demo {
    public static void main(String[] args) {
        //浮点型数据直接运算会出现精度丢失问题
        double b = 0.1;
        double a = 0.2;
//        BigDecimal类创建对象的方式
        BigDecimal b1 = BigDecimal.valueOf(a); //包装浮点数成为大数据对象
        BigDecimal a1 = BigDecimal.valueOf(b);
        BigDecimal C1 = a1.add(b1);  //a1+b1
        System.out.println(C1);
        BigDecimal c1 = a1.subtract(b1); //a1-b1
        BigDecimal c2 = a1.multiply(b1);  //a1*b1
        BigDecimal C3 = a1.divide(b1);  //  a1 / b1
        System.out.println(C3);

        // BigDecimal 只能解决精度丢失的问题,但是浮点型数据最后才是我们想要的
        double rs = c1.doubleValue();  //转换成double类型的API

        }
}

```

## 包装类的概念

```
package com.java.package_class;

/**
 八种基本数据类型
    整数类型
        整数类型    int  byte  short  long
        浮点类型 float  double
    字符型 char
    布尔型 boolean
    包装类(引用数据类型)
        Integer Byte Short Long
        Float  Double
        Char
        Boolean
 Java中的基本数据类型没有方法和属性，而包装类就是为了让这些拥有方法和属性，实现对象化交互。
 */
public class package_class_demo {
    public static void main(String[] args) {
        System.out.println("基本数据类型和引用数据类型");
//        1.自动装箱  可以把基本数据类型的值或者变量赋值给包装类
        int a = 1;
        Integer A = a;
    // 自动拆箱  将引用数据类型的变量赋值给基本数据类型
        Integer c = 100;
        int c1 = c;
        // 引用数据类型的默认值可以为null
        Integer d1 = null;
//        int d = null;  会报错

//        手工装箱
        Integer I1 = Integer.valueOf(12);



    }
}

```

```
package com.java.package_class;

public class package_class_demo2 {
    public static void main(String[] args) {
        // 包装类作为类首先继承了object类
        Integer i1 = 100;
//        转换成字符串
        String it = Integer.toString(i1);
        String it2 = i1.toString();
        System.out.println(it);
        System.out.println(it2);
        // 3直接+空字符串即可
        String it3 = it + "";


        // 把字符串数据类型的值转换成基本数据类型的值
        String numstr = "23";
        int num = Integer.parseInt(numstr);
        String DOUBLE_STR = "99.8";
        double dou = Double.parseDouble(DOUBLE_STR);
//        上面这两个已经被淘汰
        int num2 = Integer.valueOf(numstr);
        double dou2 = Double.valueOf(DOUBLE_STR);
        System.out.println(num2);
        System.out.println(dou2);





    }
}

```

```
System类获取系统时间
long time = System.currentTimeMillis()  //毫秒值
SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
sdf.format(time)

数学类
Math.abs()
Math.ceil() 向上取整
Math.floor() 向下取整
Math.pow()  a,b   a的b次方
Math.round()  
Math.round()   四舍五入

日期类
Date d1 = new Date();
获取当前时间对象
long time = d1.getTime()
SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
sdf.format(time)


日历类
日历类不同于时间对象
Calendar c1 = Calendar.getInstance();
获取年月日及时间
int year/mm/dd = c1.get(Calendar.YEAR/MONTH+1/DAY)
修改日期信息

c1.set(Calendar.YEAR, 2099)
通过日历对象拿日期对象
Date d = c1.getTime();
日历拿时间毫秒值
long time = c1.getTimeInMillis()
向后向前时间
add

大数据类  BgDecimal
将double类型改为大数据类  防止精度丢失
BigDecimal.valueOf(double a)   包装浮点数
add()  +
subtract  -
multiply *
devide   /
运算到最后都要转成double
double a = c1.doubleValue()

包装类
引用数据类型和基本数据类型
将基本数据类型的值或者变量赋值给包装类
自动装箱自动拆箱
将引用数据类型的变量赋值给基本数据类型

将字符串类型的值转换成基本数据类型
int a = Integer.valueOf(numstr);
double d = Double.valueOf(str);


```

## 泛型

```
package com.java.genericity;

import java.util.ArrayList;
/**
 泛型就是一个标签 ,<数据类型>
    泛型可以在编译阶段约束只能操作某种数据类型 泛型和集合都支持引用数据类型,不支持基本数据类型
 泛型的好处
    泛型在编译阶段约束了操作的数据类型,从而不会出现类型转换异常
    体现的是java的严谨性和规范性,数据类型经常需要统一

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
public class genericity_demo{
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
    public static<T> String arrToString(T[] nums){
        // 约束的T  T就可以接收传进来的
        StringBuilder st = new StringBuilder();
        // 拼接字符串
        st.append("[");
        // 拼接列表里面的元素
        if (nums!=null && nums.length>0){
            for(int i=0; i< nums.length; i++){
                //这样接收不管传进来的是什么类型都可以接收
                T ele = nums[i];
                st.append(i==nums.length-1?ele:ele+",");

            }

        }
        st.append("]");
        return st.toString();

    }
}
// 模拟ArrayList集合
class MyArrayList<E>{
    public void add(E e){

    }

}
```

### 泛型接口

```
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

```

泛型通配符

```
package com.java.genericity;

import java.util.ArrayList;

//通配符
public class generic_通配符 {
        public static void main(String[] args) {
            ArrayList<BMW> bmws = new ArrayList<>();
            bmws.add(new BMW());
            bmws.add(new BMW());
            bmws.add(new BMW());
            run(bmws);

            ArrayList<BENZ> benzs = new ArrayList<BENZ>();
            benzs.add(new BENZ());
            benzs.add(new BENZ());
            benzs.add(new BENZ());
            run(benzs);

        }
        //定义一个方法 可以让很多车都进来
        public static void run(ArrayList<? extends Car> cars){
            System.out.println("都可以,狗不可以");
        }
}

class Car{
}
class BMW extends Car{
}
class BENZ extends Car{
}

```

![1592444716943](C:\Users\ADMINI~1\AppData\Local\Temp\1592444716943.png)





# java基础进阶

## 单例设计模式

SingleInstance  

​	单例的意思是一个类永远只有一个对象,不能创建多个对象

### 饿汉单例模式

​	通过类获取单例对象的时候,对象已经提前做好了

实现步骤

​	1.定义一个单例类

​	2.把类的构造器私有

​	3.定义一个静态成员变量用于存储一个对象

​		(饿汉单例在返回对象的时候,对象已经做好,这里直接创建出来)

​	4.定义一个方法返回对象

### 懒汉单例模式

​	1.通过类获取单例对象的时候发现没有对象才会去创建一个对象

​	2.实现步骤

​		1.定义一个单例类

​		2.把类构造器私有

​		3.定义一个静态成员变量用于存储一个对象

​			(在返回对象的时候判断,没有对象的时候再创建,有了直接返回)

​		4.定义一个方法返回单例对象

## 枚举

​	枚举用于做信息标志和信息分类采用

​	常量做信息标志和分类:虽然也挺好,但是入参不受控制,入参太随性无法严谨

小结

​	枚举用于做信息标志和信息分类,优雅

```
package com.java.meiju;

/**
 * 目标类  枚举类的概述(面向对象的特殊类型)
 *
 *枚举类的作用?
 *  枚举用来做信息标志和信息分类.
 *枚举类的格式
    修饰符  enum 枚举名称{
    实例1名称, 实例2名称....;
 }
 枚举第一行罗列的必须是枚举名称
 源代码
 public enum Sex{
 BOY, GIRL
 }
 反编译后的枚举源代码
 public final class Sex extends java.lang.Enum<Sex> {
 public static final Sex BOY;
 public static final Sex GIRL;
 public static Sex[] values();
 public static Sex valueOf(java.lang.String);
 static {};
 }
 枚举类的特点
    1,枚举类是final修饰的,不能被继承
    2.枚举类默认继承了枚举类型 java.lang.Enum
    3.枚举类的第一行罗列的是枚举类的对象,而且是常量存储的.
    4.枚举类的第一行都是常量名称,默认存储了枚举对象
    5.枚举类的构造器默认是私有的
    6.枚举类相当于是多例设计模式
 小结:
    记住枚举的格式和特点
 作用:
    用常量做信息标志和信息分类,入参不受控制,入参太随性,无法严谨
 *
 * */

public class first_enum {
    public static void main(String[] args) {
        Sex s1 = Sex.BOY;
        System.out.println(s1);
        System.out.println(s1.ordinal()); //打印枚举对象的索引位置

    }
}

enum Sex{
    BOY, GIRL;
}
```

```
package com.java.meiju;
/**


枚举来做信息标志和信息分类可以约定后续人员开发,如果用变量来做分类和开发
 会导致move参数随机填写,随意改动



 * */
enum Oritation{
    UP, DOWN, LEFT, RIGHT;
}

public class second_enum {
//    public static final int UP = 0; // 定义常量
//    public static final int DOWN = 1;
//    public static final int LEFT = 2;
//    public static final int RIGHT = 3;
    public static void main(String[] args) {
        move(Oritation.LEFT);
    }
    //控制玛丽的移动
    public static void move(Oritation oritation){
        switch (oritation){
            case UP:
                System.out.println("控制玛丽向上移动");
                break;
            case DOWN:
                System.out.println("控制玛丽向下移动");
                break;
            case LEFT:
                System.out.println("控制玛丽向左移动");
                break;
            case RIGHT:
                System.out.println("控制玛丽向右移动");
                break;
        }
    }

}


```



## 内部类

### 内部类的分类

​	1.静态内部类

​	2.实例内部类(成员内部类)

​	3.局部内部类

​	4.匿名内部类(重点)

​	

```
package com.java.lambda_test;
/**

 1.匿名内部类是一个没有名字的内部类
 2.匿名内部类一旦写出来,就会立即创建一个匿名内部类对象返回
 3.匿名内部类的对象的类型相当于当前new的那个类型的子类类型


 * */

public class Anonymous {
    public static void main(String[] args) {
        //原本的方式
//        Animal A1 = new cat();
//        A1.run();
//        A1.test();
        // 使用抽象类的方式
        Animal a1 = new Animal() {
            @Override
            public void run() {
                System.out.println("小猫在匿名内部类重写的方法跑啊");
            }
        };
        a1.run();
        a1.test();
    }


}

class cat extends Animal{
    //重写抽象方法
    @Override
    public void run() {
        System.out.println("小猫在跑啊");
    }
}

abstract class Animal{
    //定义一个抽象方法
    public abstract void run();

    public void test(){
        System.out.println("抽象类中的方法");
    }
}

```



##  ![1593314801886](C:\Users\ADMINI~1\AppData\Local\Temp\1593314801886.png)

​	回顾tcp udp的区别

TCP可靠的,面向流的,需要建立连接

udp 无连接的 不可靠的, 可能会丢失数据



三次握手,四次挥手



public InputStream getResourceAsStream(String name)

查找具有给定名称的资源  的两种获取的方式

class.getResourceAsStream("/文件名")   代表默认去src下面寻找文件的资源

class.getClassLoder().getResourceAsStream("文件名")    不以/开头 默认是从src下来获取



