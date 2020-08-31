package cn.gsxt;

import cn.gsxt.pojo.Dog;
import cn.gsxt.pojo.person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ApplicationTests {

    @Autowired
    private Dog dog;
    @Autowired
    private person person;
    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(person);
    }

}
