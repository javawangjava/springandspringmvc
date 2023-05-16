package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;

/*
* IOC：将创建非本类对象的权力交给Spring,使用XML配置文件开发流程如下。
* 【第一步】删除使用new的形式创建对象的代码，也就是将非本类对象作为当前类的实例成员变量，将其私有化。
* 【第二步】提供依赖对象【私有化的非本类对象】对应的setter方法
* 【第三步】在当前类的bean对象中配置其属性，也就是依赖注入【简历相互依赖的bean对象的关系】
* */

public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao=new AccountDaoImpl() ;// 向上转型。这里还是在一个类中直接new创建对象的，使用IOC就把创建对象的权力交给Spring了，后面不会这样用
    private AccountDao accountDao;// 删除使用new的形式创建非本类对象的代码，那么该对象就是当前所在类的实例成员变量，需要在xml配置文件中声明。

    // 将非本类的对象私有化之后，提供对应的Setter方法来给变量传递参数
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void myMethod() {
        System.out.println("AccountService的myMethod方法执行了 ");
        accountDao.myMethod();// 对象调用接口和实现类共有的方法
    }
}
