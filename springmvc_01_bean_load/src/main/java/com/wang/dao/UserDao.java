package com.wang.dao;

import com.wang.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

// 定义持久层对应的类Dao
@Repository
public interface UserDao {
    @Insert("insert into tb_user_springmvc (name,age)values(#{name},#{age})")
    public void put(User user);

}
