package cn.gsxt.aop2;

public class Target implements TargetInter {
    public void save() {
        System.out.println("save running...........");
    }
}
