package com.wang.dao.impl;

import com.wang.dao.AccountDao;

// 自定义数据层接口的实现类，后面针对具体实际业务就可以具体化了
/*
* 1.bean的实例化是指spring实例化bean的方式，(bean是由spring的IOC来创建的)。
* 方式1：构造器实例化bean，就是在实例类中定义对应的空参构造器。spring会调用该构造器实例化对应的bean对象。
* 方式2：单独自定义静态工厂类，在静态工厂类的静态方法中返回想要的bean对象。这里的对象也要new调用对应的构造器来实例化的。也就是spring自己调用静态工厂类中的静态方法，静态方法中调用构造器来实现。
* 方式3：单独自定义实例工厂类，在实例工厂类中定义实例方法来返回想要的bean对象。这里的对象也要new调用对应的构造器来实例化的。也就是spring自己调用实例工厂类中的实例方法，实例方法中调用构造器来实现。
* 方式4：实例化FactoryBean接口来创建Bean对象。
*
* */

/*//Bean的实例化方式1：构造器实例化bean，就是在实例类中定义对应的空参构造器。spring会调用无参构造器来实例化对应的bean对象。
* 【步骤一】在类中显示写出本类对应的无参构造器即可；
* 【步骤二】在对应的xml配置文件中使用bean标签；
*
* */

public class AccountDaoImpl implements AccountDao {

    // java会默认提供类对应的无参构造。当有显性定义的有参构造，那么无参构造就不会再提供。
    // 无参构造方法如果不存在，将抛出异常 BeanCreationException,
    // Spring 创建对象使用的是无参的构造方法，而且是使用反射的方式，所以构造方法是public 或者private都可以
    public AccountDaoImpl() {
        // 下面这句话只是用来验证无参构造器是否运行了
        System.out.println("AccountDao 的无参构造器运行了");
    }

    @Override
    public void myMethod() {// 实现类重写接口方法来实现具体的功能
        System.out.println("AccountDao的myMethod方法执行了");
    }
}