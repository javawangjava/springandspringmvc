package com.wang;

import com.wang.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForLifeCycleUserDao {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContextUserDao.xml");
        //id为accountDao的bean对象scope是singleton，所以两次获取的AccountDao对象是同一个对象
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        System.out.println(userDao);
        userDao.myMethod();

    }
}
