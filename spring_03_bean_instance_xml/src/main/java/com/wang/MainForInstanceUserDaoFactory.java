package com.wang;

import com.wang.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForInstanceUserDaoFactory {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_UserDaoFactory.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        System.out.println(userDao);
        userDao.myMethod();
    }
}
