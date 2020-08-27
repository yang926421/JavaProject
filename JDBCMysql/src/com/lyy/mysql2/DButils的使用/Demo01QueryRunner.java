package com.lyy.mysql2.DButils的使用;

public class Demo01QueryRunner {
    /**
     jdbc操作数据库如果我们直接获取PreparedStatement来处理sql会比较麻烦
     使用druid连接池,获取连接对象  使用DBUtils工具类  来简化操作数据库的步骤

     核心类QueryRunner:
     空参构造器 直接创建对象
     QueryRunner只负责操作数据库 不操作连接池 所以需要传递连接进去
     类下有方法
     public int update(Connection con, String sql, Object...params)
     只能执行增删改   返回int 指处理的数据  后面的可变参数指的是为sql语句?赋值

     */
}
