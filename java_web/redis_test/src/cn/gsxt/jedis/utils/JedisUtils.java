package cn.gsxt.jedis.utils;

import javafx.beans.property.Property;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {
    private static JedisPool jedispool;

    static {
        //读取配置文件
        InputStream is = JedisPool.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建properties对象
        Properties prop = new Properties();
        //关联文件
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));

        //创建连接池对象
        jedispool = new JedisPool(config, prop.getProperty("host"), Integer.parseInt(prop.getProperty("port")));
    }

    //获取连接方法
    public static Jedis getJedis() {
        return jedispool.getResource();
    }

}
