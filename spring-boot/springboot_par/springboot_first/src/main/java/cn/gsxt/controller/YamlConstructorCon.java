package cn.gsxt.controller;

import cn.gsxt.module.AcmeConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(AcmeConstructor.class)
public class YamlConstructorCon {
    @Autowired
    private AcmeConstructor acmeConstructor;

    @RequestMapping("/testAcme21")
    public AcmeConstructor test(){
        return acmeConstructor;
    }
}
