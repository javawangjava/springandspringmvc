package com.wang.factory;


import com.wang.dao.StudentDao;
import com.wang.dao.impl.StudentDaoImpl;
import org.springframework.beans.factory.FactoryBean;

//Bean的实例化方式4：实现FactoryBean接口来创建Bean对象.
// 单独定义类来实现FactoryBean<?>，在实现类的getObject()方法中返回bean对象，getObject()方法中的bean对象也是由new调用对应的构造器来实现的。
public class StudentDaoFactoryBean implements FactoryBean<StudentDao> {

    @Override
    public StudentDao getObject() throws Exception {
        System.out.println("StudentDaoFactoryBean的getObject方法运行了");
        return new StudentDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return StudentDao.class;
    }

    @Override
    public boolean isSingleton() {
        // 返回false就是多例。返回true就是单例。
        return true;
    }
}
