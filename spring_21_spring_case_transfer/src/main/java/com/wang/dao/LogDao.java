package com.wang.dao;

import org.apache.ibatis.annotations.Insert;

// 数据层的日志
public interface LogDao {

    @Insert("insert into tb_log (info,createDate) values(#{info},now())")
    void log(String info);
}
