package cn.gsxt.demo02;

import cn.gsxt.demo01.Rent;

//房东  真是角色
public class Host implements Rent {
    public void rent() {
        System.out.println("房东要出租房屋");
    }
}
