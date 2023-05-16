package com.wang;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForDIAccountSetter {

    public static void main(String[] args) {
        //1.创建IOC容器对象，加载spring核心配置文件xml。下面使用的是加载类路径的方法来加载xml配置文件的
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDIAccountSetter" +
                ".xml");
        //2 从IOC容器中获取Bean对象(AccountDao对象)。下面是使用id从spring中获取bean对象的，使用id获取要强转对象类型。
        AccountDao accontDao = (AccountDao) applicationContext.getBean("accountDao");
        //3.使用bean对象来调用对象的方法。获取对象之后就可以调用对象的方法了
        accontDao.myMethod();

        //2 从IOC容器中获取Bean对象(BookService对象)
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        //3.使用bean对象来调用对象的方法。获取对象之后就可以调用对象的方法了
        accountService.myMethod();
    }

}
