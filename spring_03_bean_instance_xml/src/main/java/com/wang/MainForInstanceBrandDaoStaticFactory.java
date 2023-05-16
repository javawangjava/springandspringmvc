package com.wang;

import com.wang.dao.BrandDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForInstanceBrandDaoStaticFactory {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(
                "applicationContext_BrandDaoStaticFactory.xml");
        BrandDao brandDao = (BrandDao)applicationContext.getBean("brandDao");
        System.out.println(brandDao);
        brandDao.myMethod();
    }
}
