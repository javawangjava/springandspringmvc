package com.wang.dao.impl;

// 简单类型变量【类中对象的属性】的构造器方式注入

import com.wang.dao.UserDao;

// 在bean中定义简单类型属性并提供可访问的构造器，其实就是就是利用有参构造器的形参来给简单类型的属性传递参数
// 【步骤一】：在类中方法外定义简单类型的成员变量，并将该成员变量属性私有化同时提供对应的有参构造器；
// 【步骤二】：在xml配置文件中对应的bean对象中使用constructor-arg标签来设置对应的变量名name和对应的变量值value。注意constructor-arg和形参列表的类型和变量名要一一对应
//  注意constructor-arg标签中变量类型和变量名顺序与bean对象的id对应的实现类中构造器形参列表顺序一一对应
public class UserDaoImpl implements UserDao {
    // 在bean中定义简单类型（基本数据类型和String）并提供可访问的构造器来传递参数。
    private String userName;
    private int userId;

    // 显示写出无参构造器
    public UserDaoImpl() {
    }

    // 在bean中定义形参是简单类型变量类型的构造器，使用构造器的形参来传递参数。下面定义了三个不同的有参构造器
    public UserDaoImpl(String userName) {
        this.userName = userName;
    }

    public UserDaoImpl(int userId) {
        this.userId = userId;
    }

    public UserDaoImpl(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    @Override
    public void myMethod() {
        System.out.println("UserDao的myMethod方法执行了:" + userName + "," + userId);
    }
}
