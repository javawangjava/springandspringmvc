package com.wang;

import com.wang.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class MainForThirdManager {
    public static void main(String[] args) {
        //1.创建IOC容器对象，加载Spring 核心配置类
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        //2 从IOC容器中获取Bean对象
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        //3.使用bean对象来调用对象的方法。获取对象之后就可以调用对象的方法了
        System.out.println(dataSource);
    }
}
