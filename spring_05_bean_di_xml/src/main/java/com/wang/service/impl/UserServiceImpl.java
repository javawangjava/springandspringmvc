package com.wang.service.impl;


import com.wang.dao.UserDao;
import com.wang.service.UserService;
// 引用类型变量【类中对象的属性】的构造器方式注入

// 在bean中定义引用类型属性并提供可访问的构造器，其实就是就是利用有参构造器的形参来给引用类型的属性传递参数
// 【步骤一】：在类中方法外定义引用类型的成员变量，并将该成员变量属性私有化同时提供对应的有参构造器；
// 【步骤二】：在xml配置文件中对应的bean对象中使用constructor-arg标签来设置对应的变量名name和对应的ref。
public class UserServiceImpl implements UserService {
    // 在bean中定义引用类型属性并提供可访问的构造器来传递参数。
    private UserDao userDao;

    //// 显式定义出无参构造器
    public UserServiceImpl() {
    }

    // 构造器注入需要显式定义对应的有参构造器
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void myMethod() {
        System.out.println("UserService的myMethod方法执行了："+userDao);
    }
}

