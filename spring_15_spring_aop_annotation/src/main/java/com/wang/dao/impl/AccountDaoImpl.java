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

        //记录程序当前执行执行（开始时间）
        Long startTime = System.currentTimeMillis();
        //业务执行万次
        for (int i = 0;i<10000;i++) {
            System.out.println("AccountDao的myMethod方法执行了 ...");
        }
        //记录程序当前执行时间（结束时间）
        Long endTime = System.currentTimeMillis();
        //计算时间差
        Long totalTime = endTime-startTime;
        //输出信息
        System.out.println("AccountDao的myMethod方法执行万次消耗时间：" + totalTime + "ms");
    }

    @Override
    public void myMethodAop2() {
        System.out.println("AccountDao的myMethod2方法执行了：");
    }

    @Override
    public void myMethodAop3() {
        System.out.println("AccountDao的myMethod3方法执行了：");
    }
}
