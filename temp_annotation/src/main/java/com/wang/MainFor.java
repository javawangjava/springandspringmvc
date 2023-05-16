package com.wang;

import com.wang.config.SpringConfig;
import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
Spring3.0开启了纯注解开发模式，使用Java类替代配置文件，开启了Spring快速开发赛道。
Java类代替Spring核心配置文件。；
@Configuration注解用于设定当前类为配置类；
@ComponentScan注解用于设定扫描路径，此注解只能添加一次，多个数据请用数组格式；
@PropertySource加载properties配置文件

ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);//加载配置类初始化容器

不管是使用配置文件还是配置类，都必须进行对应的Spring注解包扫描才可以使用。@Autowired默认
按照类型自动装配，如果IOC容器中同类的Bean有多个，那么默认按照变量名和Bean的名称匹配，建议使用
@Qualifier注解指定要装配的bean名称
*
* */

public class MainFor {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);

        System.out.println(accountDao);
        accountDao.myMethod();

        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        System.out.println(accountService);
        accountService.myMethod();

    }
}
