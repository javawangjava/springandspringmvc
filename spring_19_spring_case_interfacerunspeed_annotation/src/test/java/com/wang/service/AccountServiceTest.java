package com.wang.service;

import com.wang.config.SpringConfig;
import com.wang.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
 * 普通Junit测试问题:在普通的测试类中，需要开发者手动加载配置文件并创建Spring容器，然后通过Spring相关API获得Bean实例。
 * 我们可以让SpringJunit负责创建Spring容器来简化这个操作，直接在测试类注入Bean实例，但需要将配置文件的名称告诉它
 * */

//使用Spring整合Junit专用的类加载器
@RunWith(SpringJUnit4ClassRunner.class)
// 使用@ContextConfiguration指定配置文件或配置类
@ContextConfiguration(classes = SpringConfig.class)// 加载配置类
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    // Account对象可以直接调用本类的public 方法，AccountService可以调用AccountService类的对象

    @Test
    public void testPut(){
        // 创建Account对象，用该对象调用Account类的Setter方法
        Account account=new Account();
        account.setId(10);
        account.setName("王五");
        account.setMoney(999.0);
        accountService.put(account);
    }

    @Test
    public void testDeleteById(){
        accountService.deleteById(4);
    }

    @Test
    public void testUpdate(){
        Account account=new Account();
        account.setId(3);
        account.setName("王五");
        account.setMoney(999.0);
        accountService.update(account);
    }

    @Test
    public void testFindAll(){
        List<Account> lists=accountService.findAll();
        System.out.println(lists);
    }

    @Test
    public void testFindById(){
        Account account=accountService.findById(1);
        System.out.println(account);
    }




}
