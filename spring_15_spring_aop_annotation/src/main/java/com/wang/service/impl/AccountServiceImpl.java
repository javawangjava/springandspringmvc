package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void myMethod() {
        System.out.println("AccountService的myMethod方法执行了:"+accountDao);
        accountDao.myMethod();
    }
}
