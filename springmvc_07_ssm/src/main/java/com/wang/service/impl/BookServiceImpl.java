package com.wang.service.impl;

import com.wang.dao.BookDao;
import com.wang.domain.Book;
import com.wang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service通过Dao层对象来操作
@Service // BookServiceImpl实现类
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    // Dao层就修改的很好，将增，删，改方法的返回值改为int型，就是表示当前操作影像的行数。
    // 因此Service层就将增改的方法判断了影响的行数是否大于0，而不是固定返回true,其实更好一些，前后逻辑一致。

    // 查单个数据只要返回数据库中的单个元素；查所有元素只要返回数据库中的所有元素，以集合形式。
    @Override// 增
    public boolean save(Book book) {
        return bookDao.save(book)>0;
    }

    @Override// 删
    public boolean delete(Integer id) {
        return bookDao.delete(id)>0;
    }

    @Override// 查
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override// 查
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override// 改
    public boolean update(Book book) {
        return  bookDao.update(book)>0;
    }


}
