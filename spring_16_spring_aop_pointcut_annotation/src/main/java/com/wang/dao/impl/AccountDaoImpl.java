package com.wang.dao.impl;

import com.wang.dao.AccountDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
//@Repository
public class AccountDaoImpl implements AccountDao {
    @Value("张三")
    private String username;
    @Value("100.0")
    private double money;
    @Override
    // Method()方法是业务模拟：计算当前方法执行万次的时间。没有使用AOP编程
    public void myMethod() {
        System.out.println("AccountDao的myMethod方法执行了：");
    }
    // myMethodAop2和myMethodAop3使用了AOP编程
    @Override
    public void myMethodAop2() {
        System.out.println("AccountDao的myMethodAop2方法执行了：");
    }

    @Override
    public void myMethodAop3(int num) {
        System.out.println("AccountDao的myMethodAop3方法执行了：");
    }
}
