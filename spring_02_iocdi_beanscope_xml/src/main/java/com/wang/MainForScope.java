package com.wang;


import com.wang.dao.AccountDao;
import com.wang.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForScope {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //id为accountDao的bean对象scope是singleton，所以两次获取的AccountDao对象是同一个对象
        AccountDao accountDao = (AccountDao)applicationContext.getBean("accountDao");
        AccountDao accountDao2 = (AccountDao)applicationContext.getBean("accountDao");
        System.out.println(accountDao);
        System.out.println(accountDao2);

        //id为userDao的bean对象scope是prototype，所以两次获取的UserDao对象不是同一个对象
        UserDao userDao=(UserDao) applicationContext.getBean("userDao");
        UserDao userDao2=(UserDao) applicationContext.getBean("userDao");
        System.out.println(userDao);
        System.out.println(userDao2);
    }
}
