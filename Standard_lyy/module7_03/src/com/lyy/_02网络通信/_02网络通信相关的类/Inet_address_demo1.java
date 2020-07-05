package com.lyy._02网络通信._02网络通信相关的类;

import java.net.InetAddress;

public class Inet_address_demo1 {
    public static void main(String[] args) throws Exception{
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostName());
        // 2.获取域名ip对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());

        // 3.获取公网IP对象。
        InetAddress ip3 = InetAddress.getByName("39.107.202.109");
        System.out.println(ip3.getHostName());
        System.out.println(ip3.getHostAddress());

    }
}
