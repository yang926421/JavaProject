package cn.gsxt.aop.impl;


import cn.gsxt.aop.Target;

public class targetImpl implements Target {
    public void save() {
        System.out.println("save running....");
    }
}
