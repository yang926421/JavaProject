package cn.gsxt.service;

import cn.gsxt.domain.Account;

import java.util.List;

public interface AccountService {

    //保存
    public void save(Account account) ;

    //查询所有
    public List<Account> findAll();
}
