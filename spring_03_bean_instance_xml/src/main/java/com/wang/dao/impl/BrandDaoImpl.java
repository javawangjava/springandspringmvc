package com.wang.dao.impl;

import com.wang.dao.BrandDao;

//bean的实例化方式2：单独自定义静态工厂类，在静态工厂类的静态方法中返回想要的bean对象。这里的对象也要new调用对应的构造器来实例化的。也就是spring自己调用静态工厂类中的静态方法，静态方法中调用构造器来实现.
/*
* 【步骤一】单独定义该类对应的静态工厂类，静态工厂类是在类中定义了一个静态的方法返回bean对象，静态方法中的bean对象也是由new调用对应的构造器来实现的。；
* 【步骤二】在对应的xml配置文件中定义bean标签
*
* */
public class BrandDaoImpl implements BrandDao {
    @Override
    public void myMethod() {
        System.out.println("BrandDao的myMethod方法执行了");
    }
}
