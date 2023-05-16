package com.wang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class MainForDataSourceXmlProperties {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDataSourceproperties.xml");
        // 连接数据池
        DataSource dataSource =( DataSource)applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }
}
