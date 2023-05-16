package com.wang;

import com.wang.config.SpringConfig;
import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*
 * 普通Junit测试问题:在普通的测试类中，需要开发者手动加载配置文件并创建Spring容器，然后通过Spring相关API获得Bean实例。
 * 我们可以让SpringJunit负责创建Spring容器来简化这个操作，直接在测试类注入Bean实例，但需要将配置文件的名称告诉它
 * */

public class MainForTest {
    public static void main(String[] args) {
        // 读取Java配置类初始化容器对象：new AnnotationConfigApplicationContext(SpringConfig.class)
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        //2 从IOC容器中获取Bean对象(AccountDao对象)。下面是使用id从spring中获取bean对象的，使用id获取要强转对象类型。
        AccountDao accontDao =applicationContext.getBean("accountDao",AccountDao.class);
        //3.使用bean对象来调用对象的方法。获取对象之后就可以调用对象的方法了
        accontDao.myMethod();

        //2 从IOC容器中获取Bean对象(BookService对象)
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        //3.使用bean对象来调用对象的方法。获取对象之后就可以调用对象的方法了
        accountService.myMethod();
    }
}
