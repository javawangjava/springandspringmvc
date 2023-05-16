package com.wang.dao.impl;

import com.wang.dao.AccountDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
注解开发Bean生命周期注解配置：
使用@PostConstruct、@PreDestroy定义bean生命周期
@PostConstruct标识构造器后
@PreDestroy标识销毁前
@PostConstruct和@PreDestroy注解是jdk中提供的注解，从jdk9开始，jdk中的javax.annotation包
被移除了，也就是说这两个注解就用不了了，可以额外导入一下依赖解决这个问题。
 */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void myMethod() {
        System.out.println("AccountDao的myMethod方法执行了：");
    }
    @PostConstruct
    public void myInit(){
        System.out.println("AccountDao的myInit方法执行了：");
    }
    @PreDestroy
    public void myDestory(){
        System.out.println("AccountDao的myDestory方法执行了：");
    }

}
