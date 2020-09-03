package cn.gsxt.controller;


import cn.gsxt.module.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//根据module的内容来书写配置文件
@RestController
public class YamlController {

    @Autowired
    private AcmeProperties acmeProperties;

    @RequestMapping("/testAcme")
    public AcmeProperties acmeProperties(){
        return acmeProperties;
    }

}
