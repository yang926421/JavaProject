package cn.gsxt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("demo")
@Controller
public class ControllerDemo {

    @RequestMapping("demo1")
    @ResponseBody
    public String test1(){
        return "hello,lyy!";
    }
}
