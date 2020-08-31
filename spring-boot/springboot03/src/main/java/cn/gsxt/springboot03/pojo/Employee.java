package cn.gsxt.springboot03.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

//员工表

@Data
@NoArgsConstructor
@Component
public class Employee {

    private  Integer id;
    private String lastName;
    private String email;
    private Integer gender; //0 女  1  男
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department, Date birth) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth;
    }
}
