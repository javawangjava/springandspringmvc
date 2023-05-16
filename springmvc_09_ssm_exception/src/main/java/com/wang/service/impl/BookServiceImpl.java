package com.wang.service.impl;

import com.wang.controller.Code;
import com.wang.dao.BookDao;
import com.wang.domain.Book;
import com.wang.exception.BusinessException;
import com.wang.exception.SystemException;
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

    //在getById演示触发异常
    @Override// 查
    public Book getById(Integer id) {

        //模拟业务异常，包装成自定义异常
        if(id == 0){
            // 此处模拟异常，当按Id查询的id为0时，触发业务异常，创建业务异常对象并上抛。
            throw new BusinessException(Code.BUSINESS_ERR,"请不要使用你的技术挑战我的耐性!");
        }
        // 模拟系统异常，try catch 会先执行try中的方法，将可能出现的异常进行包装，转换成自定义异常。
        // 下面try中出现了异常，然后在catch中认为该异常时系统异常，抛出对应的异常对象。
        try{
            //下面不注释就是异常，下面注释之后就没有异常了会执行最后的return bookDao.getById(id);。
            int i = 1/0;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"服务器访问超时，请重试!",e);
        }
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
