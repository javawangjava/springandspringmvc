package com.wang.dao.impl;

import com.wang.dao.AccountDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
//@Repository
public class AccountDaoImpl implements AccountDao {
    @Value("张三")
    private String username;
    @Value("100")
    private int money;
    @Override
    // Method()方法是业务模拟：计算当前方法执行万次的时间。没有使用AOP编程
    public int myMethod0() {
        System.out.println("AccountDao的myMethod0方法执行了："+money);
        return money;
    }

    @Override
    public void myMethod1() {
        System.out.println("AccountDao的myMethod1方法执行了：");
    }

    @Override
    public void myMethod2() {
        System.out.println("AccountDao的myMethod2方法执行了：");
    }

    @Override
    public void myMethod3() {
        //int num=1/0;// 出现异常
        System.out.println("AccountDao的myMethod3方法执行了：");
    }

    @Override
    public void myMethod4() {
        //int num=1/0;// 出现异常
        System.out.println("AccountDao的myMethod4方法执行了：");
    }

    @Override
    public void myMethod5() {
        //int num=1/0;// 出现异常
        System.out.println("AccountDao的myMethod5方法执行了：");
    }
}
