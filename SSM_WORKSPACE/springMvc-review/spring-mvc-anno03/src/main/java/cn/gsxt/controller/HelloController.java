package cn.gsxt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/h1")
    public String hello(Model model){
        //封装数据
        System.out.println("hello running");
        model.addAttribute("msg","hello,spring-mvc");
        return "hello";
    }
}
