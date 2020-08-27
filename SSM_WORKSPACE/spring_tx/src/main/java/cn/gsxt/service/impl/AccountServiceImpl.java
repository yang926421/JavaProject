//package cn.gsxt.service.impl;
//
//
//import cn.gsxt.dao.AccountDao;
//import cn.gsxt.service.AccountService;
//
//public class AccountServiceImpl implements AccountService {
//
//    private AccountDao accountDao;
//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//
//    public void transfer(String outMan, String inMan, double money) {
//        accountDao.out(outMan,money);
////        int i = 1/0;
//        accountDao.in(inMan,money);
//    }
//}


package cn.gsxt.service.impl;


import cn.gsxt.dao.AccountDao;
import cn.gsxt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
        int i = 1 / 0;
        accountDao.in(inMan, money);
    }
}
