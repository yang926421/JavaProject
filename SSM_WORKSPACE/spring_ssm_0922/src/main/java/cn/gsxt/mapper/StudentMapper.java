package cn.gsxt.mapper;

import cn.gsxt.module.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> getAll();

    public void getStudentById();
}
