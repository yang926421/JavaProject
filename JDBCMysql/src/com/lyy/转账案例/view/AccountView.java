package com.lyy.转账案例.view;

import com.lyy.转账案例.service.AccountService;

public class AccountView {
    public static void main(String[] args) {
        //定义业务需求参数
        double money = 1000;
        String inName = "jerry";
        String outName = "tom";
        AccountService acc = new AccountService();
        acc.transfer(money, inName, outName);

    }
}
