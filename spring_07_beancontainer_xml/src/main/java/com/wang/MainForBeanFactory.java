package com.wang;

import com.wang.dao.AccountDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainForBeanFactory {
    //BeanFactory创建完毕后，所有的Bean均为延迟加载，也就是说我们调用getBean()方法获取Bean对象时才创建Bean对象并返回给我们
    //BeanFactory是IoC容器的顶层接口，初始化BeanFactory对象时，加载的bean延迟加载
    //ApplicationContext接口是Spring容器的核心接口，初始化时bean立即加载
    //ApplicationContext接口提供基础的bean操作相关方法，通过其他接口扩展其功能
    //ApplicationContext接口常用初始化类:ClassPathXmlApplicationContext(常用)和FileSystemXmlApplicationContext
    public static void main(String[] args) {
        //    类路径加载配置文件
        Resource resources = new ClassPathResource("applicationContext.xml");
        BeanFactory bf = new XmlBeanFactory(resources);
        AccountDao accountDao = bf.getBean("accountDao", AccountDao.class);
        System.out.println(accountDao);
        accountDao.myMethod();
    }
}
