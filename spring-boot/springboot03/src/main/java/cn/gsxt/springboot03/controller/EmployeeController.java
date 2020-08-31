package cn.gsxt.springboot03.controller;


import cn.gsxt.springboot03.dao.DepartmentDao;
import cn.gsxt.springboot03.dao.EmployeeDao;
import cn.gsxt.springboot03.pojo.Department;
import cn.gsxt.springboot03.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/emps")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //模拟直接跳dao层
    @RequestMapping("/list")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String toAddPages(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //保存逻辑调用底层业务方法
        employeeDao.save(employee);
        return "redirect:/emps/list";
    }

    //xiugai页面


}
