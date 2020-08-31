package cn.gsxt.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class TestIndexController {

    @RequestMapping("/index1234")
    public String index(){
        return "lyy";
    }

    @RequestMapping("/test123")
    public String test(Model model){
//        model.addAttribute("message","hello,lyy");
        model.addAttribute("message","<h1>hello,springBoot<h1>");
        model.addAttribute("users", Arrays.asList("lyy","hht"));
        return "test";
    }
}
