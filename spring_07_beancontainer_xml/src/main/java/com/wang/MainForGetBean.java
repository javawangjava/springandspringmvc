package com.wang;

import com.wang.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//获取bean对象的方式
//方式一：使用bean名称获取，必须要有对应的名称。弊端：需要自己强制类型转换
//方式二：使用bean名称获取并指定类型，推荐使用
//方式三：使用bean类型获取，弊端：如果IOC容器中同类型的Bean对象有多个，此处获取会报错
public class MainForGetBean {
    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象方式一：使用bean名称获取，弊端：需要自己强制类型转换
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.myMethod();
        System.out.println(userDao);
        System.out.println("====================");
        //获取bean对象方式二：使用bean名称获取并指定类型
        UserDao userDao2=applicationContext.getBean(UserDao.class);
        userDao2.myMethod();
        System.out.println(userDao2);
        System.out.println("====================");
        //获取bean对象方式三：使用bean类型获取，弊端：如果IOC容器中同类型的Bean对象有多个，此处获取会报错
        UserDao userDao3 = applicationContext.getBean("userDao", UserDao.class);
        userDao3.myMethod();
        System.out.println(userDao3);
    }
}
