package cn.gsxt.service.impl;

import cn.gsxt.domain.Account;
import cn.gsxt.mapper.AccountMapper;
import cn.gsxt.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void save(Account account){
        try {
            //获得mapper进行相关操作
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            mapper.save(account);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> findAll() {
        //获得mapper进行相关操作
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            List<Account> accountList = mapper.findAll();
            sqlSession.close();
            return accountList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
