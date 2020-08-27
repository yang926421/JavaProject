package com.lyy._16动态代理;

public interface UserService {
    String login(String loginName, String passWord);

    void deleteAll();

    void updateAll();
}
