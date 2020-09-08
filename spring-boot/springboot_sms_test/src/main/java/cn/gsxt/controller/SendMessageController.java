package cn.gsxt.controller;

import cn.gsxt.service.SendMessage;
import com.aliyuncs.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@RestController
@CrossOrigin
public class SendMessageController {

    @Autowired
    private SendMessage sendMessage;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/send/{phone}")
    public String sendCode(@PathVariable("phone") String phone){
        //接收手机号之后，调用方法发送
        //使用redis模拟真实业务
        String code = redisTemplate.opsForValue().get(phone);
        //判断当前手机号已经存在code
        if (!StringUtils.isEmpty(code)){
            return phone + ":" + code + "已存在，还可继续使用";
        }
        //生成验证码并存储到redis中
        code = UUID.randomUUID().toString().substring(0, 6);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("code", code);
        //调用服务进行发送
        boolean isSend = sendMessage.send(phone, "SMS_201722530", paramMap);
        //如果发送成功 将这条数据放在redis中
        if (isSend){
            redisTemplate.opsForValue().set(phone, code,5, TimeUnit.MINUTES);
            return phone+":"+code+"发送成功";
        }
        else{
            return "发送失败";
        }
    }

}
