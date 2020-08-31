package cn.gsxt.springboot04.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //导入有参构造器配置
@NoArgsConstructor   //导入无参构造器配置
public class Department {
    private Integer id;
    private String name;
}
