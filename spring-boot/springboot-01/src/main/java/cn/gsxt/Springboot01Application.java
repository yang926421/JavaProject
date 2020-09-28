package cn.gsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//标注这个类是一个springboot应用
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {
        //将springboot应用启动
        SpringApplication.run(Springboot01Application.class, args);
    }

}
