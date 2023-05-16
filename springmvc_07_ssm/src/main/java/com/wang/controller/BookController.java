package com.wang.controller;

import com.wang.domain.Book;
import com.wang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 表现层开发(BookController)使用Restful风格
// 表现层接口测试是通过PostMan
// 表现层controller调用业务层service的对象

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping// 增
    public boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")// 删
    public boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    @GetMapping("/{id}")// 查
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping// 查
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @PutMapping// 改
    public boolean update(@RequestBody Book book) {
        return bookService.update(book);
    }


}
