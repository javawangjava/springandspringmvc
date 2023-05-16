package com.wang.dao.impl;

import com.wang.dao.AccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
*   Spring2.5 中注解+xml配置开发。
    注解@Component和xml文件中Bean功能类似，表示声明了一个bean对象。
    注解@Component的引号中内容相当于bean的id。
    在xml文件中开启Spring注解包扫描类似xml文件中bean标签中的bean的class属性。
    如果@Component注解没有使用参数指定Bean的名称，那么类名首字母小写就是Bean在IOC容器中的默认名称。
* */

/*
* Spring提供 @Component 注解的三个衍生注解，  衍生注解只是为了方便表示是那个层的注解
    @Controller ：用于表现层bean定义
    @Service ：用于业务层bean定义
    @Repository ：用于数据层bean定义
* */

//@Component定义bean
//@Component("accountDao")
//@Component

@Repository("accountDao")
//@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public void myMethod() {
        System.out.println("AccountDao的myMethod方法执行了：");
    }
}
