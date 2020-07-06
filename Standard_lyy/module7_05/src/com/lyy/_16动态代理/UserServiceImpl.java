package com.lyy._16动态代理;

public class UserServiceImpl implements UserService {
    @Override
    public String login(String loginName, String passWord) {
            String flag = "登陆名称或者密码错误";
            if("admin".equals(loginName) && "123456".equals(passWord)){
                flag = "success";
            }
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

            return flag;
    }


    @Override
    public void deleteAll() {

    }

    @Override
    public void updateAll() {

    }
}
