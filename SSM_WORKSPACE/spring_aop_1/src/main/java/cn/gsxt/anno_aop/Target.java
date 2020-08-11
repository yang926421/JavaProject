package cn.gsxt.anno_aop;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInter {
    public void save() {
        System.out.println("save running...........");
    }
}
