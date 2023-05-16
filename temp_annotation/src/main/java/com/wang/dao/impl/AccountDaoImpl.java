package com.wang.dao.impl;

import com.wang.dao.AccountDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

//@Repository("accountDao")
@Repository
public class AccountDaoImpl implements AccountDao {
    @Value("张三")
    private String username;
    @Value("100.0")
    private double money;
    @Override
    public void myMethod() {
        System.out.println("AccountDao的myMethod方法执行了："+username+","+money);
    }
}
