package com.lyy._01JUnit单元测试类._01Test测试;

public class UserService {

    public String login(String LoginName, String PassWord){
        if("admin".equals(LoginName)&&PassWord.equals("123456")){
            return "Success";
        }
        else
            return "用户名或者密码错误";
    }
    public void chu(int a, int b){
        int c = a/b;
        System.out.println(c);
    }



}
