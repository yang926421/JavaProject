package com.lyy.homework.day11_Homework.src.com.itheima.test02;

/**
 1. 请简述UDP协议和TCP协议各自的特点。
 答：
 UDP协议特点
 - 面向无连接的协议。
 - 只管发送，不确认对方是否接收到。
 - 基于数据包传输数据：将数据及源和目的封装成数据包中进行发送
 - 每个数据包的大小限制在64K之内。
 - 因为无需连接，速度快且是不可靠协议。

 TCP协议特点
 - 面向连接的协议。
 - 建立连接，形成传输数据的通道。
 - 传输数据大小不受限制
 - 通过三次握手完成连接。
 - TCP是基于IO流传输数据。
 - 因为需要建立连接，效率会稍低但是可靠协议
 */
public class Demo01 {

}
