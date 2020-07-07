package com.lyy._12Base64编码和解码;

import java.util.Base64;

/**

 目标: https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&
 wd=%E9%BB%91%E9%A9%AC%E7%A8%8B%E5%BA%8F%E5%91%98&rsv_pq=adb2aafb0004cea1&rsv_t=bd43rF5NublIew4JRzSmtNoJ2Dt
 x8lMAuD4NgJOFnkKoA98JL9hZ8DvnSJI
 Base64  可以实现编码和解码
    JAVA8   内置了base64的编码器和解码器
    encode编码
    decode解码
 */
public class Base64_demo {
    public static void main(String[] args) throws Exception {
        String s1 = Base64.getEncoder().encodeToString("我是lyy".getBytes());
        System.out.println(s1);
        String s2 = Base64.getUrlEncoder().encodeToString("?loginName=admin&&passWord=123456".getBytes());
        System.out.println(s2);
        byte[] buffer = Base64.getDecoder().decode(s1);
        System.out.println(new String(buffer));

        byte[] buffer2 = Base64.getUrlDecoder().decode(s2);
        System.out.println(new String(buffer2));

        //MIME编码  大段数据
        //  Base64.getMimeEncoder()
        //  Base64.getMimeDecoder()


    }
}
