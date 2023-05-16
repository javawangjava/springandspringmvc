package com.wang.service.impl;

import com.wang.domain.User;
import com.wang.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void put(User user) {
        // 下面就是检验方法题执行了
        System.out.println("UserService 的put()方法运行了");
    }
}
