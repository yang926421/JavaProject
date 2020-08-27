package com.lyy._08反射的作用在哪里;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class Mybatis {
    @Test
    public static void save(Object obj) throws Exception {
        try ( //提供一个方法,可以保存一切对象数据的字段和具体值
              PrintStream ps = new PrintStream(new FileOutputStream("module7_05/src/data.txt", true));
        ) {
            //解析对象的每个字段和每个字段的值存起来
            //先得到对象的class文件对象
            Class c = obj.getClass();
            ps.println("=====>" + c.getSimpleName() + "======");
            //定位到全部成员变量
            Field[] fields = c.getDeclaredFields();
            //遍历这些字段并取值
            for (Field field : fields) {
                //字段名称
                String name = field.getName();
                //字段的值
                field.setAccessible(true);//暴力反射
                String value = field.get(obj) + "";
                ps.println(name + "=" + value);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
