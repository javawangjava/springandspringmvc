package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// 使用注解注入引用类型变量【类中对象的属性】
//@Autowired：注入引用类型，自动装配模式，默认按类型装配
//注意：自动装配基于反射设计创建对象并暴力反射对应属性为私有属性初始化数据，因此无需提供setter方法。
//@Qualifier：自动装配bean时按bean名称装配,@Qualifier注解无法单独使用，必须配合@Autowired注解使用==
// 使用@Qualifier注解指定要装配的bean名称，目的：解决IOC容器中同类型Bean有多个装配哪一个的问题

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    // 在bean中定义引用类型并将其私有化
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    @Override
    public void myMethod() {
        System.out.println("AccountService的myMethod方法执行了："+accountDao);
        accountDao.myMethod();
    }
}
