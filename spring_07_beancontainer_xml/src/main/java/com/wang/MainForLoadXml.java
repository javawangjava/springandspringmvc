package com.wang;


import com.wang.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// 创建容器 加载xml配置文件的方式
// 方式一：类路径加载配置文件
// 方式二：文件路径加载配置文件
// 加载多个配置文件
public class MainForLoadXml {
    public static void main(String[] args) {
        // 方式一：类路径加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = (AccountDao)applicationContext.getBean("accountDao");
        System.out.println(accountDao);
        accountDao.myMethod();

        System.out.println("==============");

        // 方式二：文件路径加载配置文件
        ApplicationContext applicationContext2=new FileSystemXmlApplicationContext("D:\\JavaCode3\\spring" +
                "\\spring_07_container_xml\\src\\main\\resources\\applicationContext.xml");
        AccountDao accountDao2 = (AccountDao)applicationContext.getBean("accountDao");
        System.out.println(accountDao2);
        accountDao2.myMethod();
    }
}
