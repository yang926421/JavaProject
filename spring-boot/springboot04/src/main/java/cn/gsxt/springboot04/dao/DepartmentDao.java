package cn.gsxt.springboot04.dao;

import cn.gsxt.springboot04.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departmentMap = null;

    static{
        departmentMap = new HashMap<Integer, Department>();  //创建一个部门表
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "市场部"));
        departmentMap.put(103, new Department(103, "运营部"));
        departmentMap.put(104, new Department(104, "调研部"));
        departmentMap.put(105, new Department(105, "后勤部"));

    }

    //数据库相关操作
    //获取所有部门的信息
    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }

    //根据id获取相关部门
    public Department findDepartmentById(Integer id){
        return departmentMap.get(id);
    }
}
