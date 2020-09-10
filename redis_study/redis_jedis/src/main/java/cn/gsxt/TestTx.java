package cn.gsxt;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class TestTx {
    public static void main(String[] args) {
        // 1 new jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        // 事务操作
        System.out.println(jedis.ping());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("hello1","world1");
        Transaction multi = jedis.multi();
        String s = jsonObject.toString();
//        jedis.watch(s);
        try {
            multi.set("user1",s);
            multi.set("user2",s);
            multi.exec();
        } catch (Exception e) {
            //出现异常，放弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
