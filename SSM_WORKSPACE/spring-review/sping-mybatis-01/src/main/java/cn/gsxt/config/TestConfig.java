package cn.gsxt.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {
    @Value("哈哈哈哈")
    private String name;

    public void test1(){
        System.out.println(123456);
    }
}
