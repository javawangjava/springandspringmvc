package com.wang.dao.impl;

import com.wang.dao.UserDao;

// * 方式3：单独自定义实例工厂类，在实例工厂类中定义实例方法来返回想要的bean对象。这里的对象也要new调用对应的构造器来实例化的。也就是spring自己调用实例工厂类中的实例方法，实例方法中调用构造器来实现。
/*
 * 【步骤一】单独定义该类对应的实例工厂类，实例工厂类是在类中定义了一个实例方法返回bean对象，实例方法中的bean对象也是由new调用对应的构造器来实现的。；
 * 【步骤二】在对应的xml配置文件中定义bean标签
 *
 * */
public class UserDaoImpl implements UserDao {
    @Override
    public void myMethod() {
        System.out.println("UserDao的myMethod方法执行了");
    }
}
