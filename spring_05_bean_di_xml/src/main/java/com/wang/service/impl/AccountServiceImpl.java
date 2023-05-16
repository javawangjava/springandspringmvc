package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
// 引用类型变量【类中对象的属性】的setter方式注入

// 在bean中定义引用类型的属性并提供可访问的set方法
// 【步骤一】：在类中方法外定义引用类型的成员变量，并将该成员变量属性私有化同时提供对应的setter方法
// 【步骤二】：在xml配置文件中对应的bean对象中使用property标签来设置对应的变量名name和对应的ref。
public class AccountServiceImpl implements AccountService {

    // 在bean中定义引用类型并提供可访问的set方法来传递参数。
    private AccountDao accountDao;
    //setter注入需要提供要注入对象的set方法
    public void setAccountDao(AccountDao accountDao) {
        System.out.println("AccountDao的setter方法运行了");
        this.accountDao = accountDao;
    }

    @Override
    public void myMethod() {
        System.out.println("AccountService的myMethod方法执行了："+accountDao);
        accountDao.myMethod();
    }
}
