package com.wang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class MainForDataSourceXml {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDataSource.xml");
        // 连接数据池
        DataSource dataSource =( DataSource)applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }
}
