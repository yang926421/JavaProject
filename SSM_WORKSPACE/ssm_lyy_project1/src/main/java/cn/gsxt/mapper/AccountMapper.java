package cn.gsxt.mapper;

import cn.gsxt.domain.Account;

import java.util.List;

public interface AccountMapper {
    //保存账户数据
    public void save(Account account);

    //查询账户数据
    public List<Account> findAll();

}
