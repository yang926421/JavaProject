package cn.gsxt.springboot03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloLyy {

    @GetMapping("/hello")
    public String hello(){
        return "hello,lyy!";
    }
}
