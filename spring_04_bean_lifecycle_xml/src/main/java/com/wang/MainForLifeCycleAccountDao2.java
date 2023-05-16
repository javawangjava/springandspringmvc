package com.wang;

import com.wang.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 容器关闭前触发bean的销毁
// 关闭容器方式：
// 方式1：手工关闭容器:ConfigurableApplicationContext 接口 close() 操作；
// 方式2：注册关闭钩子，在虚拟机退出前先关闭容器再退出虚拟机:ConfigurableApplicationContext 接口 registerShutdownHook() 操作；
//此处需要使用实现类类型ClassPathXmlApplicationContext，接口类型ApplicationContext没有close方法
// 两种销毁方式都不用

public class MainForLifeCycleAccountDao2 {
    public static void main(String[] args) {
        //
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContextAccountDao2.xml");
        AccountDao accountDao = (AccountDao)applicationContext.getBean("accountDao");
        System.out.println(accountDao);
        accountDao.myMethod();
        //关闭容器方式1，关闭容器，执行销毁的方法。比较暴力
        applicationContext.close();
        System.out.println("================");
        applicationContext=new ClassPathXmlApplicationContext("applicationContextAccountDao2.xml");
        AccountDao accountDao2 = (AccountDao)applicationContext.getBean("accountDao");
        System.out.println(accountDao2);
        accountDao2.myMethod();
        //关闭容器方式2，注册关闭钩子函数，在虚拟机退出之前回调此函数，关闭容器
        applicationContext.registerShutdownHook();

    }
}
