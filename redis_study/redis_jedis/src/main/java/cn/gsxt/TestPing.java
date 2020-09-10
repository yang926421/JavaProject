package cn.gsxt;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        // 1 new jedis对象
        Jedis jedis = new Jedis("39.107.202.109", 6379);
        jedis.auth("8023514");
        // jedis所有的m命令就是我们之前学习的命令
        String ping = jedis.ping();
        System.out.println(ping);

    }
}
