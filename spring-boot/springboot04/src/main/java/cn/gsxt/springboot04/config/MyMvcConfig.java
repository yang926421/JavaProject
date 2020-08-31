package cn.gsxt.springboot04.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//全面扩展springMvc
@Configuration
//@EnableWebMvc  //注解这个标志代表全面接管spring-mvc  一般不会设置
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main.html").setViewName("dashboard");
    }
}
