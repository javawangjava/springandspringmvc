package com.wang.dao.impl;

import com.wang.dao.AccountDao;

// 自定义数据层接口的实现类，后面针对具体实际业务就可以具体化了
public class AccountDaoImpl implements AccountDao {
    @Override
    public void myMethod() {// 实现类重写接口方法来实现具体的功能
        System.out.println("AccountDao的myMethod方法执行了");
    }
}
