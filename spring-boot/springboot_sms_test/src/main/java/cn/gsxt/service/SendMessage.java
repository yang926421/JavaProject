package cn.gsxt.service;

import java.util.Map;

public interface SendMessage {
    // 参数分别为手机号  短信模板的code  验证码的code
    public boolean send(String PhoneNum, String TemplateCode, Map<String, Object> code);
}
