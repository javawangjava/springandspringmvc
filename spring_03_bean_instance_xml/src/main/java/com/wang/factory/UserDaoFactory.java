package com.wang.factory;

import com.wang.dao.UserDao;
import com.wang.dao.impl.UserDaoImpl;
// * 方式3：单独自定义实例工厂类，在实例工厂类中定义实例方法来返回想要的bean对象。这里的对象也要new调用对应的构造器来实例化的。也就是spring自己调用实例工厂类中的实例方法，实例方法中调用构造器来实现。
// 单独创建对应的实例工厂类，在实例工厂类中返回想要的bean对象
// 实例工厂类是类中定义了一个实例的方法返回bean对象，实例方法中的bean对象也是由new调用对应的构造器来实现的。

public class UserDaoFactory {
    // 实例工厂是在类中定义实例方法
    public UserDao getUserDao() {
        System.out.println("UserDao对应实例工厂类运行了");
        // 使用new调用实现类的构造器来创建对象
        return new UserDaoImpl();
    }

}
