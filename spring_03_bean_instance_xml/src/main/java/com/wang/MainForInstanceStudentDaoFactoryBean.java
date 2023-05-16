package com.wang;

import com.wang.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForInstanceStudentDaoFactoryBean {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(
                "applicationContext_StudentDaoFactoryBean.xml");
        StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
        System.out.println(studentDao);
        studentDao.myMethod();
    }
}
