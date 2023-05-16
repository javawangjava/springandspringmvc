package com.wang;


import com.wang.dao.UserDao;
import com.wang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForDIUserConstructor {

    public static void main(String[] args) {
        //1.创建IOC容器对象，加载spring核心配置文件xml。下面使用的是加载类路径的方法来加载xml配置文件的
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContextDIUserConstructor.xml");
        //// 构造器参数注入
        //2 从IOC容器中获取Bean对象(UserDao对象)。下面是使用id从spring中获取bean对象的，使用id获取要强转对象类型。
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        //3.使用bean对象来调用对象的方法。获取对象之后就可以调用对象的方法了
        userDao.myMethod();

        //2 从IOC容器中获取Bean对象(UserService对象)
        UserService userService = (UserService) applicationContext.getBean("userService");
        //3.使用bean对象来调用对象的方法。获取对象之后就可以调用对象的方法了
        userService.myMethod();

    }
}
