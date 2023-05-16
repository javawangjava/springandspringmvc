package com.wang;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
* Spring2.5 中注解+xml配置开发。
* 【步骤一】：在xml配置文件中开启context命名空间方法并开启Spring注解包扫描
* 【步骤二】在类上使用@Component注解定义Bean。
*
*
* */
public class MainForAnnotationXml {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        System.out.println(accountDao);
        accountDao.myMethod();
        System.out.println("===============");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        System.out.println(accountService);
        accountService.myMethod();
    }
}
