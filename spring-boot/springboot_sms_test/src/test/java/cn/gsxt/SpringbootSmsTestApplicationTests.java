package cn.gsxt;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;

@SpringBootTest
class SpringbootSmsTestApplicationTests {

    @Test
    void contextLoads() {
        //连接阿里云
               //构建一个客户端
        IAcsClient client = new DefaultAcsClient(profile);
        //构建一个请求
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        //配置不动
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        //自定义参数，手机号   签名  模板的code
        request.putQueryParameter("PhoneNumbers", "15839839501");
        request.putQueryParameter("SignName", "橘子商城");
        request.putQueryParameter("TemplateCode", "SMS_201722530");
        //构建短信验证码
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",520521);
        request.putBodyParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}