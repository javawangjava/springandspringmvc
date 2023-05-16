package com.wang.dao.impl;

import com.wang.dao.AccountDao;


//Bean生命周期控制【了解】
//方式1：在实现类中提供生命周期控制方法
//方式2：实现InitializingBean, DisposableBean接口

// Bean生命周期控制方式1：在实现类中提供生命周期控制方法
// 【步骤一】：在实现类中提供生命周期控制方法
// 【步骤二】：在对应的xml配置文件中声明属性
// 自定义数据层接口的实现类，后面针对具体实际业务就可以具体化了
public class AccountDaoImpl implements AccountDao {
    // 没有用工厂类方式，那么就是默认使用对应的无参构造方法来实例化Bean对象
    @Override
    public void myMethod() {// 实现类重写接口方法来实现具体的功能
        System.out.println("AccountDao的myMethod方法执行了");
    }

    //表示bean初始化对应的操作,方法名可以自己定义
    public void initMethod() {
        System.out.println("initMethod标识bean初始化对应的操作");
    }

    //表示bean销毁前对应的操作
    public void destoryMethod() {
        System.out.println("destoryMethod标识bean销毁前对应的操作");
    }


}