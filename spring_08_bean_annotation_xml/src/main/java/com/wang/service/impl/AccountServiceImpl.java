package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("accountService")
//@Component
//@Service
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Override
    public void myMethod() {
        System.out.println("AccountService的方法执行了:");
    }
}
