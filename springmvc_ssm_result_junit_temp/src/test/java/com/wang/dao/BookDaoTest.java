package com.wang.dao;

import com.wang.config.SpringConfig;
import com.wang.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//使用Spring整合Junit专用的类加载器
@RunWith(SpringJUnit4ClassRunner.class)
// 使用@ContextConfiguration指定配置文件或配置类
@ContextConfiguration(classes = SpringConfig.class)// 加载配置类

public class BookDaoTest {

    // 使用@Autowired注入需要测试的对象
    @Autowired
    private BookDao bookDao;

    // 测试查询
    // 增
    @Test
    public void testSave() {
        Book book=new Book();
        //book.setId(10);
        book.setType("数学");
        book.setName("53");
        book.setDescription("高考必备");
        bookDao.save(book);
    }

    // 删
    @Test
    public void testDelete() {
        bookDao.delete(13);
    }

    // 查
    @Test
    public void testGetById() {
        Book book = bookDao.getById(1);
        System.out.println(book);
    }

    // 查
    @Test
    public void testGetAll() {
        List<Book> all = bookDao.getAll();
        System.out.println(all);
    }

    // 改
    @Test
    public void testUpdate() {
        Book book = bookDao.getById(10);
        book.setType("数学");
        book.setName("53");
        book.setDescription("高考必备456");
        bookDao.update(book);
    }

}
