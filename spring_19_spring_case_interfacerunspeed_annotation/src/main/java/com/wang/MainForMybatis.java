package com.wang;

import com.wang.config.SpringConfig;
import com.wang.domain.Account;
import com.wang.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainForMybatis {
    public static void main(String[] args) {
        //1.创建IOC容器对象，加载Spring 核心配置类
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        //2 从IOC容器中获取Bean对象
        AccountService accountService = applicationContext.getBean(AccountService.class);
        //3.使用bean对象来调用对象的方法。获取对象之后就可以调用对象的方法了
        Account ac = accountService.findById(2);
        System.out.println(ac);
    }
}
