package com.wang.dao.impl;

import com.wang.dao.StudentDao;


/*//Bean的实例化方式4：实现FactoryBean接口来创建Bean对象.
 * 【步骤一】单独定义类来实现FactoryBean<?>，在实现类的getObject()方法中返回bean对象，getObject()方法中的bean对象也是由new调用对应的构造器来实现的。；
 * 【步骤二】在对应的xml配置文件中定义bean标签
 *
 * */
public class StudentDaoImpl implements StudentDao {
    @Override
    public void myMethod() {
        System.out.println("StudentDao 的myMethod方法运行了");
    }
}
