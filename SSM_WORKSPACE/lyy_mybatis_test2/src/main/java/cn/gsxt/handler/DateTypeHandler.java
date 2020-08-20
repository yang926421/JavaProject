package cn.gsxt.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    @Override
    //将java类型转换成数据库需要的类型  案例   date  --->  bigint
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        //将date转换为数字
        long time = date.getTime();
        //通过preparedStatement来设置参数
        preparedStatement.setLong(i, time);
    }

    @Override
    //查询的时候将数据库中的类型转换为java的类型
    //String类型要转换的字段名称
    //查询出的结果集
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //获取结果集中需要的数据(long)转换成date类型 返回
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    //查询的时候将数据库中的类型转换为java的类型
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        //获取结果集中需要的数据(long)转换成date类型 返回
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    //查询的时候将数据库中的类型转换为java的类型
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        //获取结果集中需要的数据(long)转换成date类型 返回
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
}
