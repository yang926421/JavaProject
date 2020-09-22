package cn.gsxt.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    @RequestMapping("/ajax")
    public String test(){
        return "hello";
    }
}
