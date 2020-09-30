package cn.gsxt.service.impl;

import cn.gsxt.mapper.StudentMapper;
import cn.gsxt.module.Student;
import cn.gsxt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAll () {
        List<Student> students = studentMapper.getAll();
        return students;
    }

    @Override
    public void getStudentById() {
        studentMapper.getStudentById();
    }
}
