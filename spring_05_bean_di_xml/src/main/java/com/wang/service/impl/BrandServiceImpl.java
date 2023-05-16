package com.wang.service.impl;

import com.wang.dao.BrandDao;
import com.wang.service.BrandService;

// 注解形式的依赖自动装配只能用于引用类型依赖注入，不能用于简单类型的依赖注入

// 在bean中定义引用类型的属性并提供可访问的set方法
// 【步骤一】：在类中方法外定义引用类型的成员变量，并将该成员变量属性私有化同时提供对应的setter方法
// 【步骤二】：在xml配置文件中对应的bean对象的autowire属性。
public class BrandServiceImpl implements BrandService {

    // 在bean中定义引用类型并提供可访问的set方法来传递参数。

    private BrandDao brandDao;
    //xml配置文件的引用类型的自动装配要求引用类型的bean对象要有对应的set方法，这个与jdk版本有关
    public void setBrandDao(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Override
    public void myMethod() {
        System.out.println("BrandService的myMethod方法执行了："+brandDao);

    }
}
