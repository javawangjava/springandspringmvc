package com.wang.dao.impl;

import com.wang.dao.BrandDao;

// 注解形式的依赖自动装配只能用于引用类型依赖注入，不能用于简单类型的依赖注入

// 简单类型变量【类中对象的属性】的setter方式注入

// 在bean中定义简单类型属性并提供可访问的set方法
// 【步骤一】：在类中方法外定义简单类型的成员变量，并将该成员变量属性私有化同时提供对应的setter方法
// 【步骤二】：在xml配置文件中对应的bean对象中使用property标签来设置对应的变量名name和对应的变量值value。
public class BrandDaoImpl implements BrandDao {
    // 在bean中定义简单类型（基本数据类型和String），属性私有化并提供可访问的set方法来传递参数。
    private String brandName;
    private int brandId;

    //setter注入需要提供要注入对象的set方法
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public void myMethod() {
        System.out.println("UserDao的myMethod方法执行了:" + brandName + "," + brandId);
    }
}
