package com.lyy.mysql2.lombok测试;

import domain.authors;

public class lombokDemo1 {
    public static void main(String[] args) {
//        authors author = new authors();
        authors author1 = new authors("u001", "张三", "123");
        System.out.println(author1.getUid());

    }
}
