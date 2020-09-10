package cn.gsxt.service.impl;

import cn.gsxt.service.SendMessage;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SendMessageImpl implements SendMessage {
    @Override
    public boolean send(String PhoneNum, String TemplateCode, Map<String, Object> code) {
        //连接阿里云 代码在微信
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
        request.putQueryParameter("PhoneNumbers", PhoneNum);
        request.putQueryParameter("SignName", "橘子商城");
        request.putQueryParameter("TemplateCode", TemplateCode);
        request.putBodyParameter("TemplateParam", JSONObject.toJSONString(code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
