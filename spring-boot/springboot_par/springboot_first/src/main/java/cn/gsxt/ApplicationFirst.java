package cn.gsxt;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.gsxt.mapper")
public class ApplicationFirst {
        public static void main(String[] args) {
            SpringApplication.run(ApplicationFirst.class, args);
        }

}
