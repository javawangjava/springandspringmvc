package com.wang.dao;

import com.wang.config.SpringConfig;
import com.wang.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
* 普通Junit测试问题:在普通的测试类中，需要开发者手动加载配置文件并创建Spring容器，然后通过Spring相关API获得Bean实例。
* 我们可以让SpringJunit负责创建Spring容器来简化这个操作，直接在测试类注入Bean实例，但需要将配置文件的名称告诉它
* */

//使用Spring整合Junit专用的类加载器
@RunWith(SpringJUnit4ClassRunner.class)
// 使用@ContextConfiguration指定配置文件或配置类
@ContextConfiguration(classes = SpringConfig.class)// 加载配置类
//@ContextConfiguration(value = {"classpath:applicationContext.xml"})		// 指定配置文件
public class AccountDaoTestSpringJunit {
    // 使用@Autowired注入需要测试的对象
    @Autowired
    private AccountDao accountDao;

    // 测试查询
    @Test
    public void testFindById(){
        accountDao.myMethod();
    }

}
