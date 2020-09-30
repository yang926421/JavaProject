package cn.gsxt.controller;


import cn.gsxt.module.Student;
import cn.gsxt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getAll")
    public void getAll(){
        List<Student> students = studentService.getAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
