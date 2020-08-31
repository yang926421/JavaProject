package cn.gsxt.springboot03.dao;

import cn.gsxt.springboot03.pojo.Department;
import cn.gsxt.springboot03.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    //准备数据
    private static Map<Integer, Employee> employees;

    //员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer, Employee>();
        //
        employees.put(1001, new Employee(1,"lyy","123@qq.com",1,new Department(101,"教学部"),new Date()));
        employees.put(1002, new Employee(2,"lyy1","123@qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(1003, new Employee(3,"lyy2","123@qq.com",1,new Department(101,"教学部"),new Date()));
        employees.put(1004, new Employee(4,"lyy3","123@qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(1005, new Employee(5,"lyy4","123@qq.com",1,new Department(101,"教学部"),new Date()));

    }

    //主键自增,增加一个员工
    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.findDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee findEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
