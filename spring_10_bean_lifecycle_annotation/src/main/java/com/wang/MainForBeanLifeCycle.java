package com.wang;

import com.wang.config.SpringConfig;
import com.wang.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForBeanLifeCycle {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        System.out.println(accountDao);
        accountDao.myMethod();
    }
}
