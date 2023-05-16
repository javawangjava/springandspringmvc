package com.wang.dao.impl;

import com.wang.dao.ResourcesDao;
import org.springframework.stereotype.Repository;

@Repository
public class ResourcesDaoImpl implements ResourcesDao {
    @Override
    public boolean readResources(String url, String password) {
        System.out.println(password.length());
        //    模拟校验,这里直接检查是不是字符串1234。后面可以具体化
        return password.equals("1234");
    }
}
