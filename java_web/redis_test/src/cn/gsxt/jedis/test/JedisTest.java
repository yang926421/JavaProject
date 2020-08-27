package cn.gsxt.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

//jeids的测试类
public class JedisTest {
    @Test
    public void test1() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);

        //操作
//        jedis.set("username","lyy");
//        System.out.println(jedis.get("username"));
        // setex()方法存储指定过期时间的key和value

        //关闭连接
        jedis.close();
    }
}
