package cn.gsxt.reflect;

//通过反射获取注解

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Demo04 {

    public static void main(String[] args) throws Exception {
        //测试通过反射获取到注解和注解的值
        //获取Class对象
        Class<?> aClass = Class.forName("cn.gsxt.reflect.Student");
        //获取类的注解
        for (Annotation annotation : aClass.getAnnotations()) {
            System.out.println(annotation);
        }
        //获得类的注解的值
        classTest annotation = aClass.getAnnotation(classTest.class);
        System.out.println(annotation.value());

        //获得类指定的注解
        Field name = aClass.getDeclaredField("name");
        myTest annotation1 = name.getAnnotation(myTest.class);
        System.out.println(annotation1.name());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());

    }

}


//模拟数据库的表
@classTest("db_student")
class Student{
    @myTest(name = "colName", type = "string", length = 10)
    private String name;
    @myTest(name = "idName", type = "int", length = 10)
    private int id;

    public Student() {
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

//注解类
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface classTest{
    String value();
}



//注解字段
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface myTest{
    String name();
    String type();
    int length();
}