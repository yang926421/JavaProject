package com.lyy._13lombok测试;

import com.lyy.domain.users;

public class domain_test {
    public static void main(String[] args) {
        users user1 = new users();
        user1.setAge("20");
        user1.setName("hht");
        users user = new users("lyy", "20");
        System.out.println(user.getName());
    }
}
