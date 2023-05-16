package com.wang.dao;


import com.wang.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

// 使用注解方式开发持久层接口【Dao层】
/*
先连接数据库之后，才有提示
 * 在mybatis中针对CRUD一共有四个注解
 * @Select @Insert @Update @Delete
 */
public interface AccountDao {
    @Insert("insert into tb_account(name, money) values (#{name},#{money})")
    void put(Account account);

    @Delete("delete from tb_account where id=#{id}")
    void deleteById(Integer id);

    @Update("update tb_account set name =#{name},money=#{money} where id=#{id}")
    void update(Account account);

    @Select("select * from tb_account")
    List<Account> findAll();

    @Select("select * from tb_account where id=#{id}")
    Account findById(Integer id);
}
