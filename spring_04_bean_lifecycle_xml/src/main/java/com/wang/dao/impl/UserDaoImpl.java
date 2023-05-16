package com.wang.dao.impl;

import com.wang.dao.UserDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
//Bean生命周期控制【了解】
//方式1：在实现类中提供生命周期控制方法
//方式2：实现InitializingBean, DisposableBean接口

// Bean生命周期控制方式2：实现InitializingBean, DisposableBean接口
// 【步骤一】：实现InitializingBean, DisposableBean接口,并重写对应的方法
public class UserDaoImpl implements UserDao, InitializingBean, DisposableBean {
    @Override
    public void myMethod() {
        System.out.println("UserDao的myMethod方法执行了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("UserDao 的destory方法执行了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserDao 的afterPropertiesSet方法执行了");
    }
}
