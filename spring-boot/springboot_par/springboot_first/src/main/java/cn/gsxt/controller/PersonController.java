package cn.gsxt.controller;

import cn.gsxt.module.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person(){
        System.out.println(person);
        return person;
    }
}
