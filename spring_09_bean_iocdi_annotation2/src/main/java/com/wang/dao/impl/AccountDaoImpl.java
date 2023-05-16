package com.wang.dao.impl;

import com.wang.dao.AccountDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/*
* Spring提供 @Component 注解的三个衍生注解，三个衍生注解只是方便标识是哪一个层级的数据。
    @Controller ：用于表现层bean定义
    @Service ：用于业务层bean定义
    @Repository ：用于数据层bean定义
* */

/*
*简单类型变量使用注解进行注入
* 使用@Value进行注入（无需提供set方法）
* 如果注入的参数是使用EI表达式的，那么要创建对应的properties配置文件，并在在配置类中使用@PropertySource加载properties配置文件
*
* */

//@Component定义bean
//@Component("accountDao")
//@Component

//@Repository定义bean：@Component衍生注解
//@Repository("accountDao")
@Repository
public class AccountDaoImpl implements AccountDao {
    // 在bean中定义简单类型（基本数据类型和String），属性私有化，这里${username}通过properties文件进行传入。
    @Value("张三")
    private String username;
    @Value("1000.0")
    private double money;

    @Override
    public void myMethod() {
        System.out.println("AccountDao的myMethod方法执行了："+username+","+money);
    }
}
