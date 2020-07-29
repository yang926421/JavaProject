package cn.gsxt.test;

import cn.gsxt.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileWriter;
import java.util.*;

public class jackSonTest {
    //java对象转换为json
    @Test
    public void test1() throws Exception{
        //创建person对象
        Person p  = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //创建jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();
        //使用对象进行转换
        /**
         转换方法
         writeValue(参数1， obj)
            参数一
            File  将obj对象转换为Json字符串，并保存到指定文件中
            Writer   将obj转换为json字符串，并将json数据填充到字符输出流中
            OutputStream 将obj对象转换为字符串，并将json数据填充到字节输出流中


         writeValueAsString(obj)
            将obj对象直接转换为json字符串

         */
        String json_str = mapper.writeValueAsString(p);
        System.out.println(json_str);  //{"name":"张三","age":23,"gender":"男"}

        //writeValue，将数据写到d://a.txt文件中
        //mapper.writeValue(new File("d://a.txt"),p);

        //writeValue.将数据关联到Writer中
//        mapper.writeValue(new FileWriter("d://b.txt"),p);

    }

    @Test
    public void test2() throws Exception{
        //创建person对象
        Person p  = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        //创建json转换对象
        ObjectMapper mapper = new ObjectMapper();
        //转换
        String str_json = mapper.writeValueAsString(p);
        System.out.println(str_json);

    }

    @Test
    public void test3() throws Exception{
        //创建person对象
        Person p  = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1  = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2  = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        List<Person> persons = new ArrayList<Person>();
        persons.add(p);
        persons.add(p1);
        persons.add(p2);

        //创建json转换对象
        ObjectMapper mapper = new ObjectMapper();
        //转换
        String str_json = mapper.writeValueAsString(persons);
        System.out.println(str_json);

    }

    @Test
    public void test4() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age", 23);
        map.put("gender", "男");

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }

    @Test
    public void test5() throws Exception{
        //初始化json字符串
        String S1 = "{\"gender\":\"男\",\"name\":\"zhangsan\",\"age\":23}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(S1, Person.class);

        System.out.println(person.getName());
    }
}
