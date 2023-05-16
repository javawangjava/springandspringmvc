package com.wang.factory;

//bean的实例化方式2：单独自定义静态工厂类，在静态工厂类的静态方法中返回想要的bean对象。这里的对象也要new调用对应的构造器来实例化的。也就是spring自己调用静态工厂类中的静态方法，静态方法中调用构造器来实现.

import com.wang.dao.BrandDao;
import com.wang.dao.impl.BrandDaoImpl;

// 单独创建对应的静态工厂类，在静态工厂类中返回想要的bean对象
// 静态工厂类是类中定义了一个静态的方法返回bean对象，静态方法中的bean对象也是由new调用对应的构造器来实现的。
public class BrandDaoStaticFactory {
    // 静态工厂类是类中定义了静态方法
    public static BrandDao getBrandDao(){
        // sout标识静态工厂类的方法运行了
        System.out.println("BrandDao对应的静态工厂类运行了");
        // 使用new调用实现类的构造器来创建对象
        return new BrandDaoImpl();
    }

}
