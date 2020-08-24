package cn.gsxt.mapper;

import cn.gsxt.domain.Order;
import cn.gsxt.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {


    @Select("select * from orders")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user",   //要封装的属性名称
                    column = "uid",    //根据当前查询结果的哪个字段去user表查询
                    javaType = User.class,   //要封装的实体的类型
                    // select 代表查询哪个接口的方法获得数据
                    one=@One(select = "cn.gsxt.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll();



    @Select("select * from orders where uid=#{uid}")
    public List<Order> findByUid(int uid);



//    @Select("select *, o.id oid from orders o, user u where o.uid = u.id")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "password", property = "user.password"),
//            @Result(column = "birthday", property = "user.birthday")
//    })
//    public List<Order> findAll();
}
