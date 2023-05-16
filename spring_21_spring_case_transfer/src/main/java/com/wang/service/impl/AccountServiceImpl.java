package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import com.wang.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    @Override
    //无论转账操作是否成功，日志必须保留
    public void transfer(String out, String in, Double money) {
        try{
            accountDao.inMoney(in,money);
            //int i =1/0;
            accountDao.outMoney(out,money);
        }finally {
            logService.log(out,in,money);
        }

    }
}
