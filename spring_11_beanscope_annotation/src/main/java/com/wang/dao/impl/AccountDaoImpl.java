package com.wang.dao.impl;

import com.wang.dao.AccountDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/*
注解开发Bean作用范围配置：
@Scope("prototype")// 非单例
@Scope("singleton")// 单例,默认是单例,单例模式可以省略
singleton【单例，多次获取的对象是同一个对象】，prototype【非单例，多次获取的对象不是同一个对象】
 */

@Repository("accountDao")
//@Scope("prototype")// 非单例
@Scope("singleton")// 单例,默认是单例,是同一个对象
public class AccountDaoImpl implements AccountDao {
    @Override
    public void myMethod() {
        System.out.println("AccountDao的myMethod方法执行了：");
    }
}
