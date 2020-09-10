package cn.gsxt;

import cn.gsxt.module.User;
import cn.gsxt.util.RedisUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import cn.gsxt.config.RedisConfig;


@SpringBootTest
class SpringbootRedisApplicationTests {


    @Autowired
    //注入自己写的redisTemplate
    private RedisTemplate<String, Object> redisTemplate;
    //注入我们自己封装的工具类
    @Autowired
    private RedisUtil redisUtil;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("lyy","520");
        System.out.println(redisTemplate.opsForValue().get("lyy"));

    }

    @Test
    void test() throws Exception{
        User user = new User("lyy", 3);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    //
    @Test
    void test2(){
        boolean set = redisUtil.set("name4", "lyy1234");
        System.out.println(redisUtil.get("name4"));

    }
}
