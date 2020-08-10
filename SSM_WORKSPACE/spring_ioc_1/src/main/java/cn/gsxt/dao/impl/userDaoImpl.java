package cn.gsxt.dao.impl;

import cn.gsxt.dao.userDao;
import cn.gsxt.domian.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class userDaoImpl implements userDao {
    //测试集合数据类型的注入
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public userDaoImpl() {
        System.out.println("userDaoImpl创建...");
    }

    public void init(){
        System.out.println("初始化方法");
    }

    public void save() {
        System.out.println("save running");
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
    }

    public void destory(){
        System.out.println("销毁方法");
    }
}
