package com.wang;

import com.wang.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForInstanceAccountDaoConstructor {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(
                "applicationContext_AccountDaoConstructor.xml");
        AccountDao accountDao = (AccountDao)applicationContext.getBean("accountDao");
        System.out.println(accountDao);
        accountDao.myMethod();
    }
}
