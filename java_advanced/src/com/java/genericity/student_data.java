package com.java.genericity;

//学生数据  实现接口传进来的泛型约定是学生数据
public class student_data implements Data<student> {
    @Override
    public void add(student stu) {
        System.out.println("添加学生");
    }

    @Override
    public void delete(student stu) {

    }

    @Override
    public void update(student stu) {

    }

    @Override
    public void query(student stu) {

    }
}
